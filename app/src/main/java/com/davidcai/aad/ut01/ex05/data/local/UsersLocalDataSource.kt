package com.davidcai.aad.ut01.ex05.data.local


import android.provider.Settings.Global.getString
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.domain.User
import com.google.gson.Gson


class UsersLocalDataSource {

    fun saveUsers(users: List<User>) {
        //TODO
      getUsers()
    }


    fun getUsers(): List<User>? {
        //TODO




        return emptyList()
    }

    fun findById(userId: Int): User {
        //TODO
    }

    fun remove(userId: Int) {
        //TODO

    }


}
