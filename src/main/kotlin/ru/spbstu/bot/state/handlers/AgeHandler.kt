package ru.spbstu.bot.state.handlers

import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*
import ru.spbstu.utils.isInt

class AgeHandler: StateHandler() {
    override val state = AGE

    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
        if(!message.isInt()) return "Введите число от 1 до 100" to AGE
        val age = message.toInt()
        if(age !in 1..100) return "Введите число от 1 до 100" to AGE
        userAnswers.age = age
        return "Введите свой пол (м/ж)" to GENDER
    }
}