package ru.spbstu.repo

import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState

interface UserDataRepo {
    fun getUserById(id: Long): User?
    fun getUserState(id: Long): UserBotState?
    fun setUserState(id: Long, state: UserBotState)
    fun updateUserAnswers(id: Long, answers: UserAnswers)
    fun saveUser(id: Long): User
}