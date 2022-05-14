package ru.spbstu.service

import org.jvnet.hk2.annotations.Service
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.spbstu.user.UserAnswers
import kotlin.random.Random

@Component("risks")
class RisksService(
    @Value("\${python-script-path}")
    val scriptPath: String
) {
    fun calculateRisks(answers: UserAnswers): Double{
        return Random(10).nextDouble()
    }

//    fun resolveRisk(value: Double): String{
//        TODO()
//    }
}