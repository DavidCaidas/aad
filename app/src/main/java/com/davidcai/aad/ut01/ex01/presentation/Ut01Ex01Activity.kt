package com.davidcai.aad.ut01.ex01.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.davidcai.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)


        initSharedPreferences()
    }
    private fun initSharedPreferences() {
        //val spcustomer : SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spcustomer = SharedPreferenceLocalSource(this)

        spcustomer.saveCustomer(Customer(1, "customer1", "surname1", true))

        spcustomer.saveCustomer(Customer(2, "customer2", "surname2", true))

        val newCustomer = spcustomer.getCustomer()
        Log.d("@dev", "customer: $newCustomer")
    }

    private fun initPreferences() {
        //val spcustomer : SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spcustomer = SharedPreferenceLocalSource(this)


        spcustomer.saveCustomer(Customer(3, "CUSTOMER3", "SURNAME3", true))

        val newCustomer = spcustomer.getCustomer()
        Log.d("@dev", "customer: $newCustomer")
    }
}
