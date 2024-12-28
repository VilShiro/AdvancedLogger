package org.fbs.al.util

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

open class Serializer{

    companion object {
        private val MAPPER = ObjectMapper()
        private val XML_MAPPER = XmlMapper()
    }

    constructor(){
        MAPPER.registerKotlinModule()
        XML_MAPPER.registerKotlinModule()
    }

    fun <T> serializeJson(obj: T, fileName: String) : File{
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        val file = File("$fileName.json")
        MAPPER.writeValue(file, obj)
        return file
    }

    fun <T> serializeXml(obj: T, fileName: String) : File{
        XML_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        val file = File("$fileName.xml")
        XML_MAPPER.writeValue(file, obj)
        return file
    }

    fun registerModuleJsonMapper(module: Module) : Unit{
        MAPPER.registerModules(module)
    }

    fun registerModuleXmlMapper(module: Module) : Unit{
        XML_MAPPER.registerModules(module)
    }

}