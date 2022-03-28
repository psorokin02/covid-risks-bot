package ru.spbstu.service

import org.jvnet.hk2.annotations.Service
import org.springframework.beans.factory.annotation.Value
import ru.spbstu.user.UserAnswers

@Service
class RisksService(@Value("\${python-script-path}") val scriptPath: String) {
    fun calculateRisks(answers: UserAnswers): Double{
        TODO()
    }

    fun resolveRisk(value: Double): String{
        TODO()
    }
}