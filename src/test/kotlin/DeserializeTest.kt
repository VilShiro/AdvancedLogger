import org.fbs.al.data.SerializingStrategy
import org.fbs.al.util.LogDeserializer
import org.junit.jupiter.api.Test

class DeserializeTest {

    @Test
    fun deserializeLogTest(){
        val log0 = LogDeserializer.deserializeLog(SerializingStrategy.JSON, "testLogJson")
        println(log0)
        val log1 = LogDeserializer.deserializeLog(SerializingStrategy.XML, "testLogXml")
        println(log1)
    }

    @Test
    fun deserializeLogBlockTest(){
        val logBlock0m = LogDeserializer.deserializeLogBlock(SerializingStrategy.JSON, "testLogBlockJsonAuto")
        println(logBlock0m)
        val logBlock1m = LogDeserializer.deserializeLogBlock(SerializingStrategy.XML, "testLogBlockXmlAuto")
        println(logBlock1m)

    }

    @Test
    fun massiveDeserializeLogTest(){
        val massiveLog = LogDeserializer.deserializeLogBlock(SerializingStrategy.JSON, "massiveTestJsonAuto")
        println(massiveLog)
        println(massiveLog.getLogByUID(1L))
    }

}