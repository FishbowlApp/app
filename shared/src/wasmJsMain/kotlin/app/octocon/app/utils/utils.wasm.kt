@file:OptIn(FormatStringsInDatetimeFormats::class)

package app.octocon.app.utils

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding

@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) = Unit

// Mar 6, 2026
private val dateFormatter: DateTimeFormat<LocalDateTime> = LocalDateTime.Format {
  monthName(MonthNames.ENGLISH_ABBREVIATED)
  chars(" ")
  day(Padding.NONE)
  chars(", ")
  year()
}
// 10:52 PM
private val timeFormatter: DateTimeFormat<LocalDateTime> = LocalDateTime.Format {
  amPmHour(Padding.NONE)
  chars(":")
  minute()
  chars(" ")
  amPmMarker("AM", "PM")
}

private val dateTimeFormatter: DateTimeFormat<LocalDateTime> = LocalDateTime.Format {
  monthName(MonthNames.ENGLISH_ABBREVIATED)
  chars(" ")
  day(Padding.NONE)
  chars(", ")
  year()
  chars(" at ")
  amPmHour(Padding.NONE)
  chars(":")
  minute()
  chars(" ")
  amPmMarker("AM", "PM")
}

private val monthYearFormatter: DateTimeFormat<LocalDate> = LocalDate.Format {
  monthName(MonthNames.ENGLISH_FULL)
  chars(" ")
  year()
}

@OptIn(ExperimentalWasmJsInterop::class)
actual fun LocalDateTime.dateFormat(): String =
  dateFormatter.format(this)

actual fun LocalDateTime.timeFormat(): String =
  timeFormatter.format(this)

actual fun LocalDateTime.dateTimeFormat(): String =
  dateTimeFormatter.format(this)

actual fun LocalDate.monthYearFormat(): String =
  monthYearFormatter.format(this)

@Suppress("CAST_NEVER_SUCCEEDS")
actual fun localeFormatNumber(number: Number): String =
  number.toString() // TODO

@Suppress("CAST_NEVER_SUCCEEDS")
actual fun <T> List<T>.sortedLocaleAware(selector: (T) -> String): List<T> =
  sortedWith(compareBy(selector)) // TODO

actual fun platformLog(tag: String?, message: String) {
  println("[${tag ?: "OCTOCON"}]: $message")
}