package com.jordanro.cultutetriptask.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

class TimeUtils {

    companion object{

        var dateFormatter = SimpleDateFormat("d MMM, yyyy")
        var dateParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ") // // 2016-04-04T20:55:21.000Z

        private fun serverTimeTimeStamp(date: String): Long {
            return Instant.parse(date).toEpochMilli()
        }

        fun displayDate(date: String?): String {
            if(date == null){
                return "--"
            }
            return dateFormatter.format(Date(serverTimeTimeStamp(date)))
        }
    }
}