package com.davidcai.aad.ut01.ex05.presentation

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex05.data.UserRepository
import com.davidcai.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.davidcai.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex05)

        init()
    }

    private fun init() {
        // TODO Obtain all users from data layer
        val userRepository = UserRepository(
            UsersLocalDataSource(getPreferences(Context.MODE_PRIVATE)),
            UsersRemoteDataSource()
        )

        userRepository.getUsers()
        Log.d("@dev", "Acabó userRepository.getUsers")

    }
}