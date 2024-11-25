package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class SaveUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(user: User){
        userRepository.saveUser(user)
    }
}