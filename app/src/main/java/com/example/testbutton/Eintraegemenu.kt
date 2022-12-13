package com.example.testbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Eintraegemenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eintraegemenu)

        val buttonclick = findViewById<ImageButton>(R.id.imageButton10)
        buttonclick.setOnClickListener{
            val intent = Intent(this,Eintraege::class.java)
            startActivity(intent)
        }
        //schließt das menu
        val btnMenu = findViewById<ImageButton>(R.id.btnmenu)
        btnMenu.setOnClickListener {
            val intent = Intent(this,Eintraege1::class.java)
            startActivity(intent)
        }

        val btnREE = findViewById<Button>(R.id.btnREE)
        btnREE.setOnClickListener{
            val  intent = Intent(this, RegelmaessigeEinnahmeHinzufuegen::class.java)
            startActivity(intent)
        }
        val btnRAE = findViewById<Button>(R.id.btnRAE)
        btnRAE.setOnClickListener{
            //Regelmäßige Ausgaben erstellen
            val  intent = Intent(this,RegelmaessigeAusgabeHinzufuegen::class.java)
            startActivity(intent)
        }
        val btnEE = findViewById<Button>(R.id.btnEE)
        btnEE.setOnClickListener{
            val intent = Intent(this,Einnahmehinzufuegen::class.java)
            startActivity(intent)
        }
        val btnAE = findViewById<Button>(R.id.btnAE)
        btnAE.setOnClickListener{
            val intent = Intent(this,Ausgabehinzufuegen::class.java)
            startActivity(intent)
        }



    }
}