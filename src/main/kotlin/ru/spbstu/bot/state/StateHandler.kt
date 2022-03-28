package ru.spbstu.bot.state

import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.user.User
import ru.spbstu.user.UserBotState


abstract class StateHandler {

    abstract val state: UserBotState
    fun handleMessage(message: Message, user: User): BotApiMethod<*>{
        val output: String = getOutput(message, user)
        return SendMessage(user.id.toString(), output)
    }

    abstract fun getOutput(message: Message, user: User): String
}