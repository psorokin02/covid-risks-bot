package ru.spbstu.service

import org.jvnet.hk2.annotations.Service
import org.springframework.beans.factory.annotation.Autowired
import ru.spbstu.repo.UserDataRepo
import ru.spbstu.user.UserBotState
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers

@Service
class UserService(@Autowired val userRepo: UserDataRepo) {

    fun getUserById(id: Long): User? {
        return userRepo.getUserById(id)
    }

    fun getUserState(id: Long): UserBotState? {
        return userRepo.getUserState(id)
    }

    fun setUserState(id: Long, state: UserBotState) {
        return userRepo.setUserState(id, state)
    }

    fun updateUserAnswers(id: Long, answers: UserAnswers) {
        userRepo.updateUserAnswers(id, answers)
    }

    fun saveUser(id: Long): User {
        return userRepo.saveUser(id)
    }

}