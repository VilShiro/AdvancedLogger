import org.fbs.al.data.IdAddingStrategy
import org.fbs.al.data.LogBlock
import org.fbs.al.data.SerializingStrategy
import org.fbs.al.util.LogBuilder
import org.fbs.al.util.LogSerializer
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun builderTest(){
        var st : Array<StackTraceElement> = arrayOf()
        try {
            "ggbgf".toInt()
        }catch (e : Exception){
            st = e.stackTrace
        }
        var log0  = LogBuilder()
            .className("Name0")
            .classPackage("dev.test.f")
            .message("First test message")
            .uid(5)
            .stackTrace(st)
            .getLog()

        var log1 = LogBuilder().getLog()

        println(log0)
        println(log1)
    }

    @Test
    fun blockCreateTest(){
        val block0 = LogBlock("block0", IdAddingStrategy.MANUALLY)
        val block1 = LogBlock("block1", IdAddingStrategy.AUTO)

        val log00 = LogBuilder().getLog()
        val log01 = LogBuilder().getLog()
        block0.addLog(log00)
        block0.addLog(log01)

        val log10 = LogBuilder().getLog()
        val log11 = LogBuilder().getLog()
        block1.addLog(log10)
        block1.addLog(log11)

        println(block0)
        println(block1)

        block0.removeLog(log00)
        block0.removeLog(-1)

        block1.removeLog(log10)
        block0.removeLog(block0.getLastIndex())

    }

    @Test
    fun serializeLogTest(){
        var st : Array<StackTraceElement> = arrayOf()
        try {
            "ggbgf".toInt()
        }catch (e : Exception){
            st = e.stackTrace
        }
        var log0  = LogBuilder()
            .className("Name0")
            .classPackage("dev.test.f")
            .message("First test message")
            .uid(5)
            .stackTrace(st)
            .getLog()

        LogSerializer.serialize(log0, SerializingStrategy.JSON, "testLogJson")
        LogSerializer.serialize(log0, SerializingStrategy.XML, "testLogXml")
    }

    @Test
    fun serializeLogBlockTest(){
        val log0 = LogBuilder()
            .message("test")
            .getLog()
        val log1 = LogBuilder()
            .message("test0")
            .getLog()
        val log2 = LogBuilder()
            .message("test1")
            .getLog()
        val log3 = LogBuilder()
            .message("test2")
            .getLog()

        var block0 = LogBlock("testBlockManually", IdAddingStrategy.AUTO)
        block0.addLog(log0)
        block0.addLog(log1)
        block0.addLog(log2)
        block0.addLog(log3)

        LogSerializer.serialize(block0, SerializingStrategy.JSON, "testLogBlockJsonAuto")
        LogSerializer.serialize(block0, SerializingStrategy.XML, "testLogBlockXmlAuto")
    }

}
