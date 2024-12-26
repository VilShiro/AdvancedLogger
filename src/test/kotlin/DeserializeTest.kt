import org.fbs.al.data.SerializingStrategy
import org.fbs.al.util.LogDeserializer
import org.junit.jupiter.api.Test

class DeserializeTest {

    @Test
    fun deserializeLogTest(){
        val log0 = LogDeserializer.deserializeLog(SerializingStrategy.JSON, "log/file/testLogJson")
        println(log0)
        val log1 = LogDeserializer.deserializeLog(SerializingStrategy.XML, "log/file/testLogXml")
        println(log1)
    }

    @Test
    fun deserializeLogBlockTest(){
        val logBlock0m = LogDeserializer.deserializeLogBlock(SerializingStrategy.JSON, "log/block/testLogJsonManually")
        println(logBlock0m)
        val logBlock1m = LogDeserializer.deserializeLogBlock(SerializingStrategy.XML, "log/block/testLogXmlManually")
        println(logBlock1m)

        val logBlock0a = LogDeserializer.deserializeLogBlock(SerializingStrategy.JSON, "log/block/testLogJsonAuto")
        println(logBlock0a)
        val logBlock1a = LogDeserializer.deserializeLogBlock(SerializingStrategy.XML, "log/block/testLogXmlAuto")
        println(logBlock1a)
    }

}