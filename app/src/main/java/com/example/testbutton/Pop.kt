package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Pop : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.side_menu)


        val btnuebersicht = findViewById<Button>(R.id.übersichts)
        btnuebersicht.setOnClickListener {
            val intent = Intent(this, Uebersicht::class.java)
            startActivity(intent)
        }

        val btnkategorie = findViewById<Button>(R.id.kategorie)
        btnkategorie.setOnClickListener {
            val intent = Intent(this, Kategorie::class.java)
            startActivity(intent)
        }

        val btneintraege = findViewById<Button>(R.id.eintraege)
        btneintraege.setOnClickListener {
            val intent = Intent(this, Eintraege::class.java)
            startActivity(intent)
        }
       val btnsparziel = findViewById<Button>(R.id.sparziel)
        btnsparziel.setOnClickListener {
            val intent = Intent(this, Sparziel::class.java)
            startActivity(intent)
        }
        val btnwaehrungsrechner = findViewById<Button>(R.id.währungsrechner)
        btnwaehrungsrechner.setOnClickListener {
            val intent = Intent(this, Waehrungsrechner::class.java)
            startActivity(intent)
        }
        val btnstatistik = findViewById<Button>(R.id.statistik)
        btnstatistik.setOnClickListener {
            val intent = Intent(this, Statistik::class.java)
            startActivity(intent)
        }
        val btneinstellungen = findViewById<Button>(R.id.einstellungen)
        btneinstellungen.setOnClickListener {
            val intent = Intent(this, Einstellungen::class.java)
            startActivity(intent)
        }
        val btneinnahmehinzufuegen = findViewById<Button>(R.id.plusbtn)
        btneinnahmehinzufuegen.setOnClickListener {
            val intent = Intent(this, Einnahmehinzufuegen::class.java)
            startActivity(intent)
        }
        val btnausgabehinzufuegen = findViewById<Button>(R.id.minusbtn)
        btnausgabehinzufuegen.setOnClickListener {
            val intent = Intent(this, Ausgabehinzufuegen::class.java)
            startActivity(intent)
        }








//        val displayMetrics = DisplayMetrics()
//
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val with = displayMetrics.widthPixels
//        var height = displayMetrics.heightPixels
//        window.setLayout(
//            (with *0.8) as Int,
//            (height* 0.8) as Int
//        )





    }


}