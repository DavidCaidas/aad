package com.davidcai.aad.ut01.ex06.data.local


import android.content.SharedPreferences
import android.util.Log

import com.davidcai.aad.ut01.ex06.domain.User
import com.google.gson.Gson


class UsersLocalDataSource(val sharedPref: SharedPreferences) {


    private val gson = Gson()

    fun saveUser(user: User) {
        val jsonUser = gson.toJson(user, User::class.java)
        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
        Log.d("@dev", "Entró en saveUser local")
    }

    /*

 fun saveUsers(user: User){
        val editor = sharedPref.edit()
        editor.putInt("id", user.id)
        editor.putString("name", user.name)
        editor.putString("surname", user.username)
 }

    */

    fun saveUsers(users: List<User>) {
        Log.d("@dev", "Entró en saveUsers con una lista")
        users.forEach { user ->
            saveUser(user)
        }
    }



    fun getUsers(): List<User> {
       val usersList = mutableListOf<User>()
        sharedPref.all.forEach{ entry ->
        val user = gson.fromJson(entry.value as String, User::class.java)
            usersList.add(user)
        }
        return usersList
    }


    fun getUserById(userId: Int): User? {
        val jsonUser = sharedPref.getString(userId.toString(), null) ?: return null
        return gson.fromJson(jsonUser, User::class.java)
    }


/*
    fun getUser():User = User(){

    }
    fun getUser():User {
        return User(

            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no_existe") ?: "no existe",
            sharedPref.getString("username", "no_existe") ?: "no existe",
            sharedPref.getString("email", "no_existe") ?: "no existe",


            -----sharedPref.getString("address", "no_existe") ?: "no existe",


            sharedPref.getString("phone", "no_existe") ?: "no existe",
            sharedPref.getString("website", "no_existe") ?: "no existe",
            sharedPref.getString("company")

        )

        val editor = sharedPref.edit()
    }
*/

    fun findById(userId: Int): User? {
        val jsonUser = sharedPref.getString(userId.toString(), null) ?: return null
        return gson.fromJson(jsonUser, User::class.java)
    }


    fun remove(userId: Int) {
        sharedPref.edit().remove(userId.toString()).apply()
    }


}
