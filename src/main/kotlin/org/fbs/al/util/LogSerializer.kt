package org.fbs.al.util

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.fbs.al.data.Log
import org.fbs.al.data.LogBlock
import org.fbs.al.data.SerializingStrategy
import java.io.File

class LogSerializer private constructor(){

    companion object {
        @JvmStatic
        fun serialize(log: Log, strategy: SerializingStrategy, fileName: String): File {
            when (strategy) {
                SerializingStrategy.JSON -> {
                    val serializer = Serializer()
                    serializer.registerModuleJsonMapper(JavaTimeModule())

                    val file = serializer.serializeJson(log, fileName)
                    return file
                }

                SerializingStrategy.XML -> {
                    val serializer = Serializer()
                    serializer.registerModuleXmlMapper(JavaTimeModule())

                    val file = serializer.serializeXml(log, fileName)
                    return file
                }
            }
        }
        @JvmStatic
        fun serialize(logBlock: LogBlock, strategy: SerializingStrategy, fileName: String): File {
            when (strategy) {
                SerializingStrategy.JSON -> {
                    val serializer = Serializer()
                    serializer.registerModuleJsonMapper(JavaTimeModule())

                    val file = serializer.serializeJson(logBlock, fileName)
                    return file
                }

                SerializingStrategy.XML -> {
                    val serializer = Serializer()
                    serializer.registerModuleXmlMapper(JavaTimeModule())

                    val file = serializer.serializeXml(logBlock, fileName)
                    return file
                }
            }
        }
    }

}