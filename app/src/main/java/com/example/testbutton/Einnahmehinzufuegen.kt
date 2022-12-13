package com.example.testbutton

import android.content.Intent
import android.widget.ImageButton
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Date


class Einnahmehinzufuegen : AppCompatActivity() {
//    private var texteditname : EditText? = null
//    private var texteditbetrag : EditText? = null
//    private var texteditdatum : EditText? = null
//    private var texteditkategorie : EditText? = null
//    private var texteditwaehrung : EditText? = null
//    private var savebtn : Button? = null
//    private var eintrag : Eintrag? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_einnahmehinzufuegen)

        val name : EditText = findViewById(R.id.texteditname)
        val betrag : EditText= findViewById(R.id.texteditbetrag)
        val datum : EditText= findViewById(R.id.texteditdatum)
        val kategorie : EditText= findViewById(R.id.texteditkategorie)
        val waehrung : EditText= findViewById(R.id.texteditwaehrung)


        val DB : ConnectionHelper = ConnectionHelper(this)

        val buttonClick = findViewById<ImageButton>(R.id.imageButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Pop::class.java)
            startActivity(intent)
        }
        val insertbtn : Button = findViewById(R.id.buttonsave)
        insertbtn.setOnClickListener {
            val nameTXT : String = name.text.toString()
            val betragTXT : Float = getFloat(betrag.text.toString())
            val datumTXT : String = datum.text.toString()
            val kategorieTXT : String = kategorie.text.toString()
            val waehrungTXT : String = waehrung.text.toString()

            val checkinsertdata : Boolean = DB.insertEintrag(nameTXT,betragTXT,datumTXT,kategorieTXT,waehrungTXT)
            if(checkinsertdata) {
                Toast.makeText(this,"New Entry Inserted",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"New Entry noy Inserted",Toast.LENGTH_SHORT).show()
            }
        }

    }


//    private fun initWidgets() {
//        name = findViewById(R.id.texteditname)
//        betrag = findViewById(R.id.texteditbetrag)
//        datum = findViewById(R.id.texteditdatum)
//        kategorie = findViewById(R.id.texteditkategorie)
//        waehrung = findViewById(R.id.texteditwaehrung)
//        insertbtn = findViewById(R.id.button)
//        DB = ConnectionHelper(this)
//    }

//    fun saveEinnahme(view: View?) {
//        val sqLiteManager = SQLiteManager.instanceOfDatabase(this)
//        val name = texteditname!!.text.toString()
//        val betrag = getFloat(texteditbetrag!!.text.toString()) // hier gucken wie man den  float wert bekommt
//        val datum = getDateFromString(texteditdatum!!.text.toString()) // hier gucken wie man den  datum  bekommt
//        val kategorie = texteditkategorie!!.text.toString()
//        val waehrung  = texteditwaehrung!!.text.toString()
//
//        if (eintrag == null) {
//            val id = Eintrag.eintragArrayList.size
//            val newEintrag = datum?.let { Eintrag(name, betrag, it,kategorie,waehrung) }
//            if (newEintrag != null) {
//                Eintrag.eintragArrayList.add(newEintrag)
//            }
//            if (sqLiteManager != null) {
//                if (newEintrag != null) {
//                    sqLiteManager.addEintragToDatabase(newEintrag)
//                }
//            }
//        } else {
//            eintrag!!.name = name
//            eintrag!!.betrag = betrag
//            if (datum != null) {
//                eintrag!!.datum  = datum
//            }
//            eintrag!!.kategorie = kategorie
//            eintrag!!.waehrung = waehrung
//            if (sqLiteManager != null) {
//                sqLiteManager.updateNoteInDB(eintrag!!)
//            }
//        }
//        finish()
//    }
//    fun getFloat(view: EditText): Float {
//        return getFloat(view.text.toString())
//    }
//    fun getFloat(intString: String): Float {
//        var res : Float = 0f
//        try {
//            res = java.lang.Float.valueOf(intString.toString())
//
//        } catch (e: java.lang.NumberFormatException) {
//            e.printStackTrace()
//        }
//        return res
//    }
//    private fun getStringFromDate(date: Date?): String? {
//        return if (date == null) null else SQLiteManager.dateFormat.format(date)
//    }
//
//    private fun getDateFromString(string: String): Date? {
//        return try {
//            SQLiteManager.dateFormat.parse(string)
//        } catch (e: ParseException) {
//            null
//        } catch (e: NullPointerException) {
//            null
//        }
//    }

fun getFloat(intString: String): Float {
    var res : Float = 0f
    try {
        res = java.lang.Float.valueOf(intString.toString())

    } catch (e: java.lang.NumberFormatException) {
        e.printStackTrace()
    }
    return res
}

}
