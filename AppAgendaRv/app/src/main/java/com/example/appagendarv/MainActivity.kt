package com.example.appagendarv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var contact = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
    }

    private fun loadContacts() {
        contact.add(Contact("Estefania", "123456789"))
        contact.add(Contact("Antony", "910111254"))
        contact.add(Contact("Pedro", "874927364"))
        contact.add(Contact("Popeye", "928374628"))

    }
}