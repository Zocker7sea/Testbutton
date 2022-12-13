package com.example.testbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton;


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val DB : ConnectionHelper= ConnectionHelper(this)

        val buttonClick = findViewById<ImageButton>(R.id.imageButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Pop::class.java)
            startActivity(intent)
        }


//        val btnSideEintraege = findViewById<Button>(R.id.eintraege)
//        btnSideEintraege.setOnClickListener {
//            setContentView(R.layout.eintraegeanzeigen)
//        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.popup,menu)
//        return true
//    }




}




