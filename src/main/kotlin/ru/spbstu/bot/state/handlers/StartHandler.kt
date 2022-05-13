package ru.spbstu.bot.state.handlers

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*

@Component
class StartHandler: StateHandler() {
    override val state = START
    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
        if(message != "go") return "print \'go\' to start" to START
        return "Тебе необходимо заполнить анкету из нескольких вопросов\n\n" +
                "Сколько тебе лет (число от 1 до 100)" to AGE
    }

}