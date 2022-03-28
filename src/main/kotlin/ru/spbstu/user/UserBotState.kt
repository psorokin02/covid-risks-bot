package ru.spbstu.user

import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.meta.api.objects.Message

enum class UserBotState(val messageOutput: String) {
    GREETING("hello") {
        override fun handleMessage(message: Message, user: User) {
            TODO("Not yet implemented")
        }
    },

    START("asking smt") {
        override fun handleMessage(message: Message, user: User) {
            TODO("Not yet implemented")
        }
    },

    OUTPUT_RESULT ("") {
        override fun handleMessage(message: Message, user: User) {
            TODO("Not yet implemented")
        }
    };
    abstract fun handleMessage(message: Message, user: User)
}