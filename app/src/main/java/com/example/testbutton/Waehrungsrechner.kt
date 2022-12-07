package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Waehrungsrechner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waehrungsrechner)

        val buttonClick = findViewById<ImageButton>(R.id.imageButton2)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Pop::class.java)
            startActivity(intent)
        }
    }
}