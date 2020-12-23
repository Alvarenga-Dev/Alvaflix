package com.alvarengadev.alvaflix.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class FormatDate {
    companion object {
        fun getDate(date: String): String {
            val formatDate = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val day = formatDate.parse(date)!!
            return DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).format(day)
        }
    }
}