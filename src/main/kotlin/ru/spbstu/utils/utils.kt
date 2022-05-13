package ru.spbstu.utils

fun String.isInt(): Boolean =
    try {
        this.toInt()
        true
    }catch (e: Exception){
        false
    }
