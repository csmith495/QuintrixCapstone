package com.example.contactcapstone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etNumber = findViewById<EditText>(R.id.etNumber)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.btnAddContact)

        val data = ArrayList<ContactViewModel>()



        button.setOnClickListener {
            if(areFieldsFilled(etName.text.toString(), etNumber.text.toString())) {
                data.add(ContactViewModel(etName.text.toString(), etNumber.text.toString()))

                val adapter = CustomAdapter(data)

                recyclerview.adapter = adapter
                Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Please enter contact info", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun areFieldsFilled(name: String, number: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(number))
    }
}