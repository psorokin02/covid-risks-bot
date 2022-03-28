package ru.spbstu.bot.state.handlers

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.User
import ru.spbstu.user.UserBotState

@Component
class OutputResultHandler: StateHandler() {
    override val state: UserBotState
        get() = UserBotState.OUTPUT_RESULT

    override fun getOutput(message: Message, user: User): String {
        TODO("Not yet implemented")
    }
}