package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class UserDataRepository(private val localData: LoginXmlLocalDataSource):UserRepository {
}