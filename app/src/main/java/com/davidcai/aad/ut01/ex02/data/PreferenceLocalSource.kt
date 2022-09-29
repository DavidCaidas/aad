package com.davidcai.aad.ut01.ex02.data

import android.app.Activity
import android.content.Context

import com.davidcai.aad.ut01.ex02.domain.App

class PreferenceLocalSource (val activity: Activity) {
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )



    fun saveApp(app: App) {
        val editor = sharedPref.edit()

        editor.apply {
            putBoolean("true", app.FirstTime)
            apply()
        }
    }


        fun getApp(): App {
            return App(
                sharedPref.getBoolean("FirstTime", true)

            )
            val editor = sharedPref.edit()
        }


    }

