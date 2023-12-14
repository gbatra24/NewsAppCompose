package com.gagan.newsapp.utils.extentions

fun String.removeExtraChars(): String {
    return if (this.contains("... [")) this.substringBefore("[") else this
}
