package org.fbs.al.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.fbs.al.util.LogBuilder
import java.util.*

open class LogBlock(
    private val blockName: String,
    private val idAddingStrategy: IdAddingStrategy) {

    @JsonCreator constructor(
        @JsonProperty("blockName") blockName: String,
        @JsonProperty("idAddingStrategy") idAddingStrategy: IdAddingStrategy,
        @JsonProperty("content") logs: ArrayList<Log>) : this(blockName, idAddingStrategy) {
            this.logs = logs
    }

    @JsonProperty("content")
    private var logs = ArrayList<Log>()

    fun getLogs() : Collection<Log>{
        return Collections.unmodifiableList<Log>(logs)
    }

    fun getLog(i : Int) : Log{
        return logs[i]
    }

    fun getLogByUID(uid: Long) : Log? {
        for (log: Log in logs){
            if(log.getUID() == uid){
                return log
            }
        }
        return null
    }

    fun addLog(log : Log){
        val id : Long = if (idAddingStrategy == IdAddingStrategy.AUTO){
            logs.getLast()?.getUID()?.plus(1L) ?: 0
        } else{
            log.getUID()
        }

        logs.add(LogBuilder().copyLog(log)
            .uid(id)
            .getLog())

    }

    fun removeLog(log : Log){
        logs.remove(log)
    }

    fun removeLog(id: Long){
        for (log: Log in logs){
            if(log.getUID() == id){
                removeLog(log)
                break
            }
        }
    }

    fun getBlockName() : String{
        return blockName
    }

    @JsonIgnore
    fun getLastIndex() : Long{
        if (idAddingStrategy == IdAddingStrategy.MANUALLY) {
            var last: Long = -2
            for (log: Log in logs) {
                if (log.getUID() > last){
                    last = log.getUID()
                }
            }
            return last
        }
        else{
            return logs.getLast()?.getUID() ?: -1
        }
    }

    fun getIdAddingStrategy() : IdAddingStrategy{
        return idAddingStrategy
    }

    override fun toString(): String {
        return "BlockName: $blockName\nContent:\n${toString(logs)}"
    }

    private fun toString(logs : ArrayList<Log>) : String{
        var builder = StringBuilder()
        for (log : Log in logs){
            builder.append(log.toString()).append("\n")
        }
        return builder.toString()
    }

}

private fun <T> ArrayList<T>.getLast() : T? {
    if (isEmpty){
        return null
    }
    return get(size - 1)
}
