package ru.spbstu.bot.state.handlers

import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*

class WasIllHandler: StateHandler() {
    override val state = WAS_ILL

    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
        if(message !in listOf("да","нет"))
            return "Болели ли вы короновирусом (да/нет)" to WAS_ILL
        
    }
}