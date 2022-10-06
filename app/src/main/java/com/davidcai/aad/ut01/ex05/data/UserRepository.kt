package com.davidcai.aad.ut01.ex05.data

import android.util.Log
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.davidcai.aad.ut01.ex05.domain.User

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
            Log.d("@dev", "Guardó en local")
        }
        Log.d("@dev", "Devolvió usuarios")
        return users
    }
/*
    fun getUserById (userId: Int) : User {
        // TODO: verify in local, else do in remote
    }

    fun removeUser(userId: Int){
        // TODO (local
    }

 */
}