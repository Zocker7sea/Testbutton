package com.example.testbutton

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity;
import android.content.Intent
import android.view.Menu;
import android.view.MenuInflater
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener
import android.view.View;
import android.widget.Button
import android.widget.ImageButton;
import android.widget.PopupMenu
import android.widget.Toast;




class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        



        val buttonClick = findViewById<ImageButton>(R.id.imageButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this@MainActivity, Pop::class.java)
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




