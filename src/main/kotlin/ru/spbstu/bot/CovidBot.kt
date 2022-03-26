package ru.spbstu.bot

import org.telegram.telegrambots.bots.TelegramWebhookBot
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update

class CovidBot: TelegramWebhookBot() {
    override fun getBotToken(): String {
        TODO("Not yet implemented")
    }

    override fun getBotUsername(): String {
        TODO("Not yet implemented")
    }

    override fun onWebhookUpdateReceived(p0: Update?): BotApiMethod<*> {
        TODO("Not yet implemented")
    }

    override fun getBotPath(): String {
        TODO("Not yet implemented")
    }
}