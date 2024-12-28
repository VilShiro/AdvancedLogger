package org.fbs.al.util

import org.fbs.al.data.Log
import java.time.LocalDateTime
import java.util.Collections

class LogBuilder {

    private var classPackage: String = ""
    private var className: String = ""
    private var date: LocalDateTime = LocalDateTime.now()
    private var message: String = ""
    private var stackTrace: Collection<StackTraceElement> = Collections.unmodifiableList(ArrayList<StackTraceElement>())
    private var UID: Long = -1

    private var dateSet: Boolean = false

    fun classPackage(classPackage: String) : LogBuilder{
        this.classPackage = classPackage
        return this
    }

    fun className(className: String) : LogBuilder{
        this.className = className
        return this
    }

    fun date(date: LocalDateTime) : LogBuilder{
        this.date = date
        dateSet = true
        return this
    }

    fun message(message: String) : LogBuilder{
        this.message = message
        return this
    }

    fun stackTrace(stackTrace: Collection<StackTraceElement>) : LogBuilder{
        this.stackTrace = stackTrace
        return this
    }

    fun stackTrace(stackTrace: Array<StackTraceElement>) : LogBuilder{
        this.stackTrace = Collections.unmodifiableList(stackTrace.asList())
        return this
    }

    fun uid(uid: Long) : LogBuilder{
        this.UID = uid
        return this
    }

    fun copyLog(log: Log) : LogBuilder{
        className = log.getClassName()
        classPackage = log.getClassPackage()
        stackTrace = log.getStackTrace()
        message = log.getMessage()
        date = log.getDate()
        return this
    }

    fun getLog() : Log{
        return Log(
            if (classPackage == "") "unknown" else classPackage,
            if (className == "") "unknown" else className,
            if (!dateSet) LocalDateTime.now() else date,
            if (message == "") "no message" else message,
            stackTrace.ifEmpty { Collections.unmodifiableList(ArrayList<StackTraceElement>()) },
            UID
        )
    }

}