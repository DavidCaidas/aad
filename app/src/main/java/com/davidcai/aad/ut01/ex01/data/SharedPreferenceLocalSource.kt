package com.davidcai.aad.ut01.ex01.data

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex01.domain.Customer


class SharedPreferenceLocalSource (val activity: AppCompatActivity){

    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)


fun saveCustomer(customer: Customer){
   val editor= sharedPref.edit()

    //estilo kotlin

    editor.apply {
        putInt("id",customer.id)
        putString("name",customer.name)
        putString("surname",customer.surname)
        putBoolean("is_active",customer.isActive)
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


    fun getCustomer(): Customer{
        return Customer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name","no_existe") ?: "no existe",
            sharedPref.getString("surname","no_existe")?: "no existe",
            sharedPref.getBoolean("is_active",true)

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