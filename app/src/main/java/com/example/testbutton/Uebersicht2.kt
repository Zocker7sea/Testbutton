package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Uebersicht2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uebersicht2)
        val buttonClick = findViewById<ImageButton>(R.id.imageButton2)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Uebersicht::class.java)
            startActivity(intent)
        }
    }
}