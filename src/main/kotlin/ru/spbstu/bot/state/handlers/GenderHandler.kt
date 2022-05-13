package ru.spbstu.bot.state.handlers

import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*

class GenderHandler: StateHandler() {
    override val state = GENDER

    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
        if(message !in listOf("м", "ж")) return "Введите свой пол (м/ж)" to GENDER
        if(message == "м")
            userAnswers.gender = 0
        else
            userAnswers.gender = 1
        return "Болели ли вы короновирусом (да/нет)" to WAS_ILL
    }
}