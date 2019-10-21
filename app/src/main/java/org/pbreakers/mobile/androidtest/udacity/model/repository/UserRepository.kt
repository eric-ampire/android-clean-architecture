package org.pbreakers.mobile.androidtest.udacity.model.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.pbreakers.mobile.androidtest.udacity.model.api.UserApi
import org.pbreakers.mobile.androidtest.udacity.model.dao.UserDao

class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {

    val data = userDao.findAll()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val users = userApi.getAllAsync().await()
            userDao.add(users)
        }
    }
}