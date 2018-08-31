package kyrpapados.footballapp.utils.helper

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class FormatHelper {
    companion object {
        fun getDateCalendar(): Calendar {
            val cal = Calendar.getInstance()
            //cal.setTime(dateObject);
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)

            return cal
        }

        fun getSeason(date: String): String {
            return formatDate("yyyy-MM-dd", date, "yyyy")
        }

        fun getTimeNoSeconds(date: String): String {
            return formatDate("HH:mm:ss", date, "HH:mm")
        }

        fun getTimeWithSecond(date: String): String {
            return formatDate("yyyy-MM-dd HH:mm:ss", date, "HH:mm:ss")
        }

        fun getDate(date: String): String {
            return formatDate("yyyy-MM-dd", date.substringBefore("T"), "dd/MM/yyyy")
        }

        fun formatSeason(datePattern: String, date: String, postFormatString: String): String {
            val postFormat = SimpleDateFormat(postFormatString, Locale.US)
            val preFormatString = SimpleDateFormat(datePattern, Locale.US)
            //"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            preFormatString.timeZone = TimeZone.getTimeZone("GMT")
            var result: String
            val convertedDate: Date
            try {
                convertedDate = postFormat.parse(date)
                result = postFormat.format(convertedDate)
            } catch (e: Exception) {
                e.printStackTrace()
                result = "n/a"
            }

            return result
        }

        fun formatDate(datePattern: String, date: String, postFormatString: String): String {
            val postFormat = SimpleDateFormat(postFormatString, Locale.getDefault())
            val preFormatString = SimpleDateFormat(datePattern, Locale.getDefault())
            var result: String
            val convertedDate: Date
            try {
                convertedDate = preFormatString.parse(date)
                result = postFormat.format(convertedDate)
            } catch (e: Exception) {
                e.printStackTrace()
                result = "n/a"
            }

            return result
        }

        //Convert timestamp to date
        fun getDate(time: Long, format: String): String {
            try {
                val cal = Calendar.getInstance(Locale.ENGLISH)
                cal.timeInMillis = time * 1000L
                return DateFormat.format(format, cal).toString()
            } catch (ex: Exception) {
                return "n/a"
            }

        }
    }

}