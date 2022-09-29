package com.davidcai.aad.ut01.ex02.data

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex02.domain.App



class SharedPreferenceLocalSource (val activity: AppCompatActivity){

    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)


fun saveApp(app: App){
   val editor= sharedPref.edit()

    //estilo kotlin

    editor.apply {
        putBoolean("true",app.FirstTime)
        apply()
    }

    /* estilo java

    editor.putInt("id",customer.id)
    editor.putString("name",customer.name)
    editor.putString("surname",customer.surname)
    editor.putBoolean("is_active",customer.isActive)
    editor.apply()      //asincrono
    //editor.commit()     sincrono

    */

}


    fun getApp(): App{
        return App(
            sharedPref.getBoolean("true",true)

        )
        val editor = sharedPref.edit()
    }

}


/*
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.rafaelmardom.aad.R
import com.rafaelmardom.aad.ut01.domain.Customer

// Fichero que maneja datos locales.
// Fichero XML que permite guardar datos del tipo clave / valor
class SharedPreferenceLocalSource (val activity: AppCompatActivity){
    // R.string viene del XML strings.xml
    // Aquí no estamos en un activity, lo que significa que hay que usar la clase Activity
    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)
    }
}
 */