package ru.spbstu.user

import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.meta.api.objects.Message

enum class UserBotState() {

    GREETING{
        override fun ask() =
            "Hello, print \'go\' to start" to START
    },

    START{
        override fun ask() =
            "Hello, print \'go\' to start" to AGE
    },

    AGE{
        override fun ask() =
            "Hello, print \'go\' to start" to GENDER
    },

    GENDER{
        override fun ask() =
            "Hello, print \'go\' to start" to WAS_ILL
    },

    WAS_ILL{
        override fun ask() =
            "Hello, print \'go\' to start" to WAS_VACCINE
    },

    WAS_VACCINE{
        override fun ask() =
            "Hello, print \'go\' to start" to PLACES_FREQUENCY
    },

    PLACES_FREQUENCY{
        override fun ask() =
            "Hello, print \'go\' to start" to MASK
    },

    MASK{
        override fun ask() =
            "Hello, print \'go\' to start" to POPULATION
    },

    POPULATION{
        override fun ask() =
            "Hello, print \'go\' to start" to GOT_RESULT
    },

    GOT_RESULT {
        override fun ask() =
            "Hello, print \'go\' to start" to START
    },
    abstract fun ask(): Pair<String, UserBotState>
}