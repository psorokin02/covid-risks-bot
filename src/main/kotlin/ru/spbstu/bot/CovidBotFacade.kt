package ru.spbstu.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import ru.spbstu.bot.state.StateContext
import ru.spbstu.service.UserService
import ru.spbstu.user.User

@Component
class CovidBotFacade(
    @Autowired
    val stateContext: StateContext,
    @Autowired
    val userService: UserService
) {
    fun onWebhookUpdateReceived(update: Update?): BotApiMethod<*>? {
        if (update != null && update.hasMessage()) {
            var user = userService.getUserById(update.message.chatId)
            if(user == null) user = userService.saveUser(update.message.chatId)
            return handleMessage(update.message, user)
        }
        return null
    }

    private fun handleMessage(message: Message, user: User): BotApiMethod<*>? {
        return stateContext.handleMessage(message, user)
    }
}