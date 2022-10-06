package com.davidcai.aad.ut01.ex05.data.local


import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import android.util.Log
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.domain.User
import com.google.gson.Gson



class UsersLocalDataSource (val sharedPref: SharedPreferences){

    private val gson = Gson()

    fun saveUser(user: User){
        val jsonUser = gson.toJson(user, User::class.java)
        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
        Log.d("@dev", "Entró en saveUser local")
    }
    /*
        fun getUser():User = User(

        )


     */
    fun saveUsers(users:MutableList<User>){
        Log.d("@dev", "Entró en saveUsers con una lista")
        users.forEach { user ->
            saveUser(user)
        }
    }

    fun getUsers(): List<User>? = null
/*
    fun findById(userId: Int): User {
        return // TODO return a user
    }

    fun remove(userId: Int){
        // TODO remove a user from list
    }

    fun saveUsers() {
        TODO("Not yet implemented")
    }


 */

}
