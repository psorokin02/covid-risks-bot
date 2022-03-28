package ru.spbstu.repo

import org.springframework.stereotype.Repository
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState

@Repository
class InMemoryUserRepo: UserDataRepo {

    val usersList: List<User> = mutableListOf()
    override fun getUserById(id: Long): User? {
        TODO("Not yet implemented")
    }

    override fun getUserState(id: Long): UserBotState? {
        TODO("Not yet implemented")
    }

    override fun setUserState(id: Long, state: UserBotState) {
        TODO("Not yet implemented")
    }

    override fun updateUserAnswers(id: Long, answers: UserAnswers) {
        TODO("Not yet implemented")
    }

    override fun saveUser(id: Long): User {
        TODO("Not yet implemented")
    }
}