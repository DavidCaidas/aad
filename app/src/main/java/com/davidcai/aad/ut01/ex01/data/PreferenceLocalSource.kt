package com.davidcai.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.davidcai.aad.ut01.ex01.domain.Customer

class PreferenceLocalSource (val activity: Activity) {
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )



    fun saveCustomer(customer: Customer) {
        val editor = sharedPref.edit()

        editor.apply {
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()
        }
    }


        fun getCustomer(): Customer {
            return Customer(
                sharedPref.getInt("id", 0),
                sharedPref.getString("name", "no_existe") ?: "no existe",
                sharedPref.getString("surname", "no_existe") ?: "no existe",
                sharedPref.getBoolean("is_active", true)

            )
            val editor = sharedPref.edit()
        }


    }

