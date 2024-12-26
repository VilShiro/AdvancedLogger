package org.fbs.al.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.fbs.al.Log
import org.fbs.al.data.LogBlock
import org.fbs.al.data.SerializingStrategy
import java.io.File

class LogSerializer private constructor() {

    companion object {
        @JvmStatic
        fun serialize(log: Log, strategy: SerializingStrategy, fileName: String): File {
            when (strategy) {
                SerializingStrategy.JSON -> {
                    val mapper = ObjectMapper()
                    mapper.registerModules(JavaTimeModule())
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    val file = File("$fileName.json")
                    mapper.writeValue(file, log)
                    return file
                }

                SerializingStrategy.XML -> {
                    val xmlMapper = XmlMapper()
                    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    xmlMapper.registerModules(JavaTimeModule())

                    xmlMapper.writeValue(File("$fileName.xml"), log)
                    return File("$fileName.xml")
                }
            }
        }
        @JvmStatic
        fun serialize(logBlock: LogBlock, strategy: SerializingStrategy, fileName: String): File {
            when (strategy) {
                SerializingStrategy.JSON -> {
                    val mapper = ObjectMapper()
                    mapper.registerModules(JavaTimeModule())
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    val file = File("$fileName.json")
                    mapper.writeValue(file, logBlock)
                    return file
                }

                SerializingStrategy.XML -> {
                    val xmlMapper = XmlMapper()
                    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    xmlMapper.registerModules(JavaTimeModule())

                    xmlMapper.writeValue(File("$fileName.xml"), logBlock)
                    return File("$fileName.xml")
                }
            }
        }
    }

}