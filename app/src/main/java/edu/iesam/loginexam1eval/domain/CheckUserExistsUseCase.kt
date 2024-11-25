package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class CheckUserExistsUseCase(private val userRepository: UserRepository) {

    operator fun invoke(user: User):Boolean{
        val user = userRepository.getUserByEmail(user.email)
        return if (user==null){
            false
        }else{
            true
        }
    }
}