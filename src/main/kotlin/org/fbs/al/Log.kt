package org.fbs.al

import java.time.LocalDateTime

data class Log(
    private val classPackage: String,
    private val className: String,
    private val date: LocalDateTime,
    private val message: String,
    private val stackTrace: Collection<StackTraceElement>,
    private val UID: Long) : Cloneable{

    override fun clone(): Log {
        return Log(classPackage,
            className,
            date,
            message,
            stackTrace,
            -1)
    }

    fun getClassPackage() : String{
        return classPackage
    }

    fun getClassName() : String{
        return className
    }
    fun getMessage() : String{
        return message
    }
    fun getDate() : LocalDateTime{
        return date
    }
    fun getStackTrace() : Collection<StackTraceElement>{
        return stackTrace
    }
    fun getUID() : Long{
        return UID
    }

    override fun toString(): String {
        return "ClassName: $className, ClassPackage: $classPackage, Date: $date, Message: $message, Stacktrace: $stackTrace UID: $UID"
    }

    companion object
}
