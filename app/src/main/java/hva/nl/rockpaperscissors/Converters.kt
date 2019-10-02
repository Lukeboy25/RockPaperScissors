package hva.nl.rockpaperscissors

import android.annotation.TargetApi
import android.os.Build
import androidx.room.TypeConverter
import hva.nl.rockpaperscissors.model.GameEnum
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class Converters {
    @TargetApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? {
        return if (dateString == null) {
            null
        } else {
            LocalDateTime.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? {
        return if (date == null) {
            null
        } else {
            date!!.toString()
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun <T : Enum<T>> T.toInt(): Int = this.ordinal
    private inline fun <reified T : Enum<T>> Int.toEnum(): T = enumValues<T>()[this]

    @TypeConverter fun myEnumToTnt(value: GameEnum) = value.toInt()
    @TypeConverter fun intToMyEnum(value: Int) = value.toEnum<GameEnum>()
}