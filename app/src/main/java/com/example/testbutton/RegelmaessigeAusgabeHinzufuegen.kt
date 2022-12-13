package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class RegelmaessigeAusgabeHinzufuegen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regelmaessige_ausgabe_hinzufuegen)

        val buttonclick = findViewById<ImageButton>(R.id.imageButton)
        buttonclick.setOnClickListener {
            intent = Intent(this,Pop::class.java)
            startActivity(intent)
        }
    }
}