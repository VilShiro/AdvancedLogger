package org.fbs.al.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.fbs.al.Log
import org.fbs.al.data.LogBlock
import org.fbs.al.data.SerializingStrategy
import java.io.File

class LogDeserializer private constructor(){

    companion object{
        @JvmStatic
        fun deserializeLog(strategy: SerializingStrategy, filename: String) : Log{
            when(strategy){
                SerializingStrategy.JSON -> {
                    val mapper = ObjectMapper()
                    mapper.registerModules(JavaTimeModule())
                    return mapper.readValue<Log>(File("$filename.json"), Log::class.java)
                }
                SerializingStrategy.XML -> {
                    val xmlMapper = XmlMapper()
                    xmlMapper.registerModules(JavaTimeModule())
                    return xmlMapper.readValue<Log>(File("$filename.xml"), Log::class.java)
                }
            }
        }

        @JvmStatic
        fun deserializeLogBlock(strategy: SerializingStrategy, filename: String) : LogBlock{
            when(strategy){
                SerializingStrategy.JSON -> {
                    val mapper = ObjectMapper()
                    mapper.registerModules(JavaTimeModule())
                    return mapper.readValue<LogBlock>(File("$filename.json"), LogBlock::class.java)
                }
                SerializingStrategy.XML -> {
                    val xmlMapper = XmlMapper()
                    xmlMapper.registerModules(JavaTimeModule())
                    return xmlMapper.readValue<LogBlock>(File("$filename.xml"), LogBlock::class.java)
                }
            }
        }
    }

}
