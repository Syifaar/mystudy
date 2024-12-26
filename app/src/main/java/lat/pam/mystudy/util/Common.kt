package lat.pam.mystudy.util

import android.annotation.SuppressLint
import android.os.Message
import androidx.compose.material3.SnackbarDuration
import androidx.compose.ui.graphics.Color
import lat.pam.mystudy.ui.theme.Blue
import lat.pam.mystudy.ui.theme.Orange
import lat.pam.mystudy.ui.theme.Red
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

enum class Priority(val title: String, val color: Color, val value: Int) {
    LOW(title = "Low", color = Blue, value = 0),
    MEDIUM(title = "Medium", color = Orange, value = 1),
    HIGH(title = "High", color = Red, value = 2);

    companion object{
        fun fromInt(value: Int) = values().firstOrNull { it.value == value } ?: MEDIUM
    }
}

@SuppressLint("NewApi")
fun Long?.changeMillisToDateString(): String {
    val date: LocalDate = this?.let {
        Instant
            .ofEpochMilli(it)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    } ?:LocalDate.now()
    return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
}

fun Long.toHours(): Float {
    val hours = this.toFloat() / 3600f
    return String.format(Locale.US, "%.2f", hours).toFloat()
}

sealed class SnackbarEvent {
    data class ShowSnackbar(
        val message: String,
        val duration: SnackbarDuration = SnackbarDuration.Short
    ) : SnackbarEvent()

    data object NavigateUp: SnackbarEvent()
}

fun Int.pad(): String{
    return this.toString().padStart(length = 2, padChar = '0')
}