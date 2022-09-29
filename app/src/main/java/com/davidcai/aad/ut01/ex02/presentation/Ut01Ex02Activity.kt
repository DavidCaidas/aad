package com.davidcai.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex02.data.SharedPreferenceLocalSource
import com.davidcai.aad.ut01.ex02.domain.App

class ut01ex02Activity : AppCompatActivity() {

    var isFirstOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        Log.d("@dev", "primera vez")

        isFirstOpened = true


        if (sharedPref.getBoolean("FirstTime")==true) {
            "nothing"
        } else {
            sharedPreference.setBoolean("FirstTime")
        }


    }

        private fun initSharedPreferences() {
            //val spcustomer : SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
            val spapp = SharedPreferenceLocalSource(this)

            spapp.saveApp(App(true))

            val newApp = spapp.getApp()
            Log.d("@dev", "app: $newApp")
        }

        private fun initPreferences() {
            //val spcustomer : SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
            val spapp = SharedPreferenceLocalSource(this)


            spapp.saveApp(App(true))

            val newApp = spapp.getApp()
            Log.d("@dev", "app: $newApp")
        }


    }