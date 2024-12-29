# Advanced logger

Creation, serialization, deserialization of logs as class objects in Runtime.

<!-- TOC -->
* [Getting started](#getting-started)
  * [Creating Log](#creating-log)
  * [Creating LogBlock](#creating-logblock)
  * [Serializing](#serializing)
  * [Deserializing](#deserializing)
* [Thanks](#thanks)
<!-- TOC -->

## Getting started

### Creating Log

```kotlin
fun createLog(){
    val log = LogBuilder()
        .message("Your message") // This message has been contained in log
        .classPackage("Your class package like com.company.app") // For example, you have class in package com.company.app
        .className("Your class name like Test") // And for example, in com.company.app you have Test.java class
        // .stackTrace() You can add exception stacktrace to your log
        // .date() You can set data and time to log, by default LogBuilder gets LocalDateTime.now()
        // .uid() You can set UID to your log, default value is '-1'
        .getLog()
}
```

### Creating LogBlock

```kotlin
fun createLogBlock(){
    val logBlock = LogBlock(
        "Your block name", // You can add name to your block for find it in file
        IdAddingStrategy.AUTO // Log UID automatically set to next UID, started by 0
        // Or IdAddingStrategy.MANUALLY, Log UID do not be edited
    )
    logBlock.addLog(log) // with method addLog(log : Log) you can add Log to your LogBlock
}
```

### Serializing

```kotlin
fun serialize(){
    LogSerializer.serialize(
        log, // or logBlock
        // Log or LogBlock class object for serializing

        SerializingStrategy.JSON, // or SerializingStrategy.XML
        // Select file type for serializing

        "Your file name" // You can choose file name for serialized data(you don't need to specify the file extension)
    )
}
```

### Deserializing

```kotlin
fun deserialize(){
    var log = LogDeserializer.deserializeLog(
            SerializingStrategy.JSON,
    "Name of your serialized file"
    )
    var logBlock = LogDeserializer.deserializeLogBlock(
            SerializingStrategy.JSON,
    "Name of your serialized file"
    )
}
```

## Thanks

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Jackson Project](https://github.com/FasterXML/jackson)
