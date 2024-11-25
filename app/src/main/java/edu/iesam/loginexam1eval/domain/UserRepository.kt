package edu.iesam.loginexam1eval.domain

interface UserRepository {

    fun getUserByEmail(email: String): User?
    fun saveUser(user: User)

}