package com.davidcai.aad.ut01.ex05.data

import android.app.Activity
import android.content.Context
import android.util.Log
import com.davidcai.aad.ut01.ex01.domain.Customer
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.davidcai.aad.ut01.ex05.domain.User
import com.google.gson.Gson
import java.nio.file.Files.find

class UserRepository(
    val localSource: UsersLocalDataSource,
    val remoteSource: UsersRemoteDataSource
) {

    /**
     * First from local and then from remote
     */

    fun getUsers(): List<User>? {
        var users = localSource.getUsers()
        if (users == null) {
            users = remoteSource.getUsers()
            localSource.saveUsers(users as MutableList<User>)
        }

        return users
    }


    fun getUserById(userId: Int): User {
        var user = localSource.findById(userId)
        if (user == null) {
            user = remoteSource.getUser(userId)
        }
        return user
    }



    fun removeUser(userId: Int) {
        localSource.remove(userId)
    }

    /*

fun removeUser(userId: Int){
           }
    */
}