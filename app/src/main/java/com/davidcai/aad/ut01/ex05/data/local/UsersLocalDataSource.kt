package com.davidcai.aad.ut01.ex05.data.local


import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex01.domain.Customer
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.domain.User
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
        return emptyList()
    }
/*
    fun getUser():User = User(){

    }
*/

    fun getUser():User {
        return User(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no_existe") ?: "no existe",
            sharedPref.getString("username", "no_existe") ?: "no existe",
        )
        val editor = sharedPref.edit()
    }


    fun findById(userId: Int): User? {
        val jsonUser = sharedPref.getString(userId.toString(), null) ?: return null
        return gson.fromJson(jsonUser, User::class.java)
    }


    fun remove(userId: Int) {
        sharedPref.edit().remove(userId.toString()).commit()
    }


}
