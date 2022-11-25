package com.berners.truecaller.util

import com.berners.truecaller.MainApplication
import com.berners.truecaller.R
import kotlinx.datetime.*
//import org.ocpsoft.prettytime.PrettyTime
import java.time.DayOfWeek
import java.time.format.DateTimeFormatter

object TimeUtils {
    fun timeZone(): TimeZone {
        return TimeZone.currentSystemDefault()
    }

    fun today(): LocalDate {
        return Clock.System.todayIn(timeZone())
    }

    fun LocalDateTime.isToday(): Boolean {
        return this.date == today()
    }

    fun LocalDateTime.isYesterday(): Boolean {
        return this.date.daysUntil(today()) == 1
    }

    fun LocalDateTime.isCurrentYear(): Boolean {
        return this.date.year == today().year
    }

    fun LocalDateTime.format(format: String): String {
        return this.toJavaLocalDateTime().format(DateTimeFormatter.ofPattern(format))
    }

    fun LocalDate.dayOfWeekName(): String {
        return when(this.dayOfWeek) {
            DayOfWeek.MONDAY -> MainApplication.instance.getString(R.string.monday)
            DayOfWeek.TUESDAY -> MainApplication.instance.getString(R.string.tuesday)
            DayOfWeek.WEDNESDAY -> MainApplication.instance.getString(R.string.wednesday)
            DayOfWeek.THURSDAY -> MainApplication.instance.getString(R.string.thursday)
            DayOfWeek.FRIDAY -> MainApplication.instance.getString(R.string.friday)
            DayOfWeek.SATURDAY -> MainApplication.instance.getString(R.string.saturday)
            DayOfWeek.SUNDAY -> MainApplication.instance.getString(R.string.sunday)
        }
    }

    fun LocalDateTime.simplePrettyDate(): String {
        if (this.isToday()) {
            return this.format("hh:mm")
        }

        if (this.isYesterday()) {
            return MainApplication.instance.getString(R.string.yesterday)
        }

        val daysUntil = this.date.daysUntil(today())
        if (daysUntil <= 7) {
            return this.date.dayOfWeekName()
        }

        //TODO: get current datetime format

        if (this.isCurrentYear()) {
            return this.format("dd/MM")
        }

//        val prettyTime = PrettyTime()
//        return prettyTime.format(this.toJavaLocalDateTime())
        return this.format("dd/MM/yyyy")
    }
}
