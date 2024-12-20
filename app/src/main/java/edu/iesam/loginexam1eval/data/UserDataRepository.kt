package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.User
import edu.iesam.loginexam1eval.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class UserDataRepository(private val localData: LoginXmlLocalDataSource):UserRepository {

    override fun getUserByEmail(email: String): User? {
        return localData.findById(email)
    }

    override fun saveUser(user: User) {
        localData.save(user)
    }


}