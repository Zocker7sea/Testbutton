package com.example.testbutton

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Eintraege1 : AppCompatActivity() {
    //private var eintraegeListView: ListView? = null


    var DB : ConnectionHelper = ConnectionHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eintraege1)

        val buttonClick  = findViewById<ImageButton>(R.id.imageButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this,Eintraege::class.java)
            startActivity(intent)
        }

        val btnMenu = findViewById<ImageButton>(R.id.btnmenu)
        btnMenu.setOnClickListener {
            val intent = Intent(this, Eintraegemenu::class.java)
            startActivity(intent)
        }

        val viewdata = findViewById<Button>(R.id.view)
//        viewdata.setOnClickListener {
//            val res : Cursor = DB.datum
//            if(res.count == 0) {
//                Toast.makeText(this,"No ENtry Exists",Toast.LENGTH_SHORT).show()
//            }
//            val buffer : StringBuffer = StringBuffer()
//            while (res.moveToNext()) {
//                buffer.append("Datum :" + res.getString(3)+"\n")
//            }
//            val builder : AlertDialog.Builder = AlertDialog.Builder(this)
//            builder.setCancelable(true)
//            builder.setTitle("User Datum")
//            builder.setMessage(buffer.toString())
//            builder.show()
//        }

        viewdata.setOnClickListener {
            val res : Cursor = DB.getdata()
            if(res.count == 0) {
                Toast.makeText(this,"No ENtry Exists",Toast.LENGTH_SHORT).show()
            }
            val buffer : StringBuffer = StringBuffer()
            while (res.moveToNext()) {
                buffer.append("ID : " + res.getString(0) + "\n")
                buffer.append("Name :" + res.getString(1)+"\n")
                buffer.append("Betrag :" + res.getString(2)+"\n")
                buffer.append("Datum :" + res.getString(3)+"\n")
                buffer.append("Kategorie :" + res.getString(4)+"\n")
                buffer.append("Währung :" + res.getString(5)+"\n\n")
            }
            val builder : AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setCancelable(true)
            builder.setTitle("User Entry")
            builder.setMessage(buffer.toString())
            builder.show()
        }
//        initWidgets()
//        loadFromDBToMemory()
//        setEintrageAdapter()
//        setOnClickListener()


    }

//    private fun initWidgets() {
//        eintraegeListView = findViewById(R.id.eintraegeListView)
//    }
//
//    private fun loadFromDBToMemory() {
//        val sqLiteManager = SQLiteManager.instanceOfDatabase(this)
//        if (sqLiteManager != null) {
//            sqLiteManager.populateEintraegeList()
//        }
//    }
//
//    private fun setEintrageAdapter() {
//        val eintragAdapter = EintragAdapter(applicationContext, Eintrag.nonDeletedNotes())
//        eintraegeListView!!.adapter = eintragAdapter
//    }
//    private fun setOnClickListener() {
//        eintraegeListView!!.onItemClickListener =
//            AdapterView.OnItemClickListener { adapterView, view, position, l ->
//                val selectedEintrag = eintraegeListView!!.getItemAtPosition(position) as Eintrag
//                val editEintragIntent = Intent(applicationContext, EintragDetailActivity::class.java)
//                editEintragIntent.putExtra(Eintrag.NOTE_EDIT_EXTRA, selectedEintrag.name)
//                startActivity(editEintragIntent)
//            }
//    }
//    //zum hinzufuegen von eintraegen
////    fun newEintrag(view: View?) {
////        val newEintragIntent = Intent(this, EintragDetailActivity::class.java)
////        startActivity(newEintragIntent)
////    }
//
//    override fun onResume() {
//        super.onResume()
//        setEintrageAdapter()
//    }
}