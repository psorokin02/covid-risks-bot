package ru.spbstu.bot.state

import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState


abstract class StateHandler {

    abstract val state: UserBotState
    fun handleMessage(message: Message, user: User): BotApiMethod<*>{
        val output = handleMessage(message.text, user.answers)
        user.state = output.second
        return SendMessage(user.id.toString(), output.first)
    }

    protected abstract fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState>
}