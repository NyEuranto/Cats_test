package com.cats.mabanquetest.utilities

import java.util.*

object DateUtils {

    fun formatDateFromTime (timeStampString: String?): String{
        val timeStamp = timeStampString?.toLongOrNull() ?: return ""
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = timeStamp
        return android.text.format.DateFormat.format("dd/MM/yyyy", calendar).toString()
    }
}