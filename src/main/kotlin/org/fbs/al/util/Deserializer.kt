package org.fbs.al.util

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

class Deserializer {

    companion object {
        private val MAPPER = ObjectMapper()
        private val XML_MAPPER = XmlMapper()
    }

    constructor(){
        MAPPER.registerKotlinModule()
        XML_MAPPER.registerKotlinModule()
    }

    fun <T> deserializeJson(file : File, clazz : Class<T>) : T{
        return MAPPER.readValue<T>(file, clazz)
    }

    fun <T> deserializeXml(file : File, clazz : Class<T>) : T{
        return XML_MAPPER.readValue<T>(file, clazz)
    }

    fun registerModuleJsonMapper(module: Module) : Unit{
        MAPPER.registerModules(module)
    }

    fun registerModuleXmlMapper(module: Module) : Unit{
        XML_MAPPER.registerModules(module)
    }

}