package org.fbs.al.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Log @JsonCreator constructor (
    @JsonProperty("classPackage") private val classPackage: String,
    @JsonProperty("className") private val className: String,
    @JsonProperty("date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") private val date: LocalDateTime,
    @JsonProperty("message") private val message: String,
    @JsonProperty("stackTrace") private val stackTrace: Collection<StackTraceElement>,
    @JsonProperty("uid") private val UID: Long) : Cloneable{

    override fun clone(): Log {
        return Log(classPackage,
            className,
            date,
            message,
            stackTrace,
            -1)
    }

    fun getClassPackage() : String{
        return classPackage
    }

    fun getClassName() : String{
        return className
    }
    fun getMessage() : String{
        return message
    }
    fun getDate() : LocalDateTime{
        return date
    }
    fun getStackTrace() : Collection<StackTraceElement>{
        return stackTrace
    }
    fun getUID() : Long{
        return UID
    }

    override fun toString(): String {
        return "ClassName: $className, ClassPackage: $classPackage, Date: $date, Message: $message, Stacktrace: $stackTrace UID: $UID"
    }

}
