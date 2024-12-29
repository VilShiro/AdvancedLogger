package org.fbs.al.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.fbs.al.data.Log
import org.fbs.al.data.LogBlock
import org.fbs.al.data.SerializingStrategy
import java.io.File

class LogDeserializer private constructor(){

    companion object{
        @JvmStatic
        fun deserializeLog(strategy: SerializingStrategy, filename: String) : Log{
            when(strategy){
                SerializingStrategy.JSON -> {
                    val deserializer = Deserializer(true)
                    deserializer.registerModuleJsonMapper(JavaTimeModule())
                    return deserializer.deserializeJson(File("$filename.json"), Log::class.java)
                }
                SerializingStrategy.XML -> {
                    val deserializer = Deserializer(true)
                    deserializer.registerModuleXmlMapper(JavaTimeModule())
                    return deserializer.deserializeXml(File("$filename.xml"), Log::class.java)
                }
            }
        }

        @JvmStatic
        fun deserializeLogBlock(strategy: SerializingStrategy, filename: String) : LogBlock{
            when(strategy){
                SerializingStrategy.JSON -> {
                    val deserializer = Deserializer(true)
                    deserializer.registerModuleJsonMapper(JavaTimeModule())
                    return deserializer.deserializeJson(File("$filename.json"), LogBlock::class.java)
                }
                SerializingStrategy.XML -> {
                    val deserializer = Deserializer(true)
                    deserializer.registerModuleXmlMapper(JavaTimeModule())
                    return deserializer.deserializeXml(File("$filename.xml"), LogBlock::class.java)
                }
            }
        }
    }

}
