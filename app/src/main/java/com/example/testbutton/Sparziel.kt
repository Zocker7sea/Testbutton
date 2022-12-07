package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sparziel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sparziel)

        //Hauptaufgaben
        val btnsparziel1 = findViewById<Button>(R.id.sparziel1)
        btnsparziel1.setOnClickListener {
            val intent = Intent(this, Sparziel1::class.java)
            startActivity(intent)
        }
        val btnsparziel2 = findViewById<Button>(R.id.sparziel2)
        btnsparziel2.setOnClickListener {
            val intent = Intent(this, Sparziel2::class.java)
            startActivity(intent)
        }

        //uebersicht
        val btnuebersicht = findViewById<Button>(R.id.übersichts)
        btnuebersicht.setOnClickListener {
            val intent = Intent(this, Uebersicht::class.java)
            startActivity(intent)
        }
        //Kategorie
        val btnkategorie = findViewById<Button>(R.id.kategorie)
        btnkategorie.setOnClickListener {
            val intent = Intent(this, Kategorie::class.java)
            startActivity(intent)
        }
        //eintraege
        val btneintraege = findViewById<Button>(R.id.eintraege)
        btneintraege.setOnClickListener {
            val intent = Intent(this, Eintraege::class.java)
            startActivity(intent)
        }
        //sparziel
        val btnsparziel = findViewById<Button>(R.id.sparziel)
        btnsparziel.setOnClickListener {
            val intent = Intent(this, Pop::class.java)
            startActivity(intent)
        }
        //waehrungsrechner
        val btnwaehrungsrechner = findViewById<Button>(R.id.währungsrechner)
        btnwaehrungsrechner.setOnClickListener {
            val intent = Intent(this, Waehrungsrechner::class.java)
            startActivity(intent)
        }
        //statistik
        val btnstatistik = findViewById<Button>(R.id.statistik)
        btnstatistik.setOnClickListener {
            val intent = Intent(this, Statistik::class.java)
            startActivity(intent)
        }
        //einstellungen
        val btneinstellungen = findViewById<Button>(R.id.einstellungen)
        btneinstellungen.setOnClickListener {
            val intent = Intent(this, Einstellungen::class.java)
            startActivity(intent)
        }
        //Einnahmen
        val btnplus = findViewById<Button>(R.id.plusbtn)
        btnplus.setOnClickListener {
            val intent = Intent(this, Einnahmehinzufuegen::class.java)
            startActivity(intent)
        }
        //Ausgaben
        val btnminus = findViewById<Button>(R.id.minusbtn)
        btnminus.setOnClickListener {
            val intent = Intent(this, Ausgabehinzufuegen::class.java)
            startActivity(intent)
        }
    }
}