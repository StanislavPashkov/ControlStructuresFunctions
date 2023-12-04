package ru.netology

val seconds = 1320
val minutes = (seconds / 60)
val hours = (minutes / 60)
val minuteText = minute(minutes)
val hourText = hour(hours)

fun agoToText(seconds: Int) = when (seconds) {
    in 0..60 -> "только что"
    in 61..60 * 60 -> "$minutes $minuteText назад"
    in 60 * 60 + 1..24 * 60 * 60 -> "$hours $hourText назад"
    in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "сегодня"
    in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "вчера"
    in 3 * 24 * 60 * 60..Int.MAX_VALUE -> "давно"
    else -> "неверное время"
}

fun minute(minutes: Int): String {
    if (minutes in 11..14) return "минут"
    return when (minutes % 10) {
        1 -> "минуту"
        2, 3, 4 -> "минуты"
        in 5..9, 0 -> "минут"
        else -> "неверное время"
    }
}

fun hour(hours: Int): String {
    if (hours in 11..14) return "часов"
    return when (hours % 10) {
        1 -> "час"
        2, 3, 4 -> "часа"
        in 5..9, 0 -> "часов"
        else -> "неверное время"
    }
}

fun main() {
    val test = agoToText(seconds)
    if (seconds > 60 * 60) println("был(а) в сети $test") else println("был(а) $test")
}
