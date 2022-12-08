package com.example.testbutton

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import com.example.testbutton.SQLiteManager
import kotlin.math.E

class EintragDetailActivity : AppCompatActivity() {

    private var nameEditText: EditText? = null
    private var betraEditText: EditText? = null
    private var datumEditText: EditText? = null
    private var kategorieEditText : EditText? = null
    private var waehrungEditText : EditText? = null

    private var selectedEintrag: Eintrag? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_einnahmendetailansicht)
        initWidgets()
        checkForEditNote()
   }

    private fun initWidgets() {
        nameEditText = findViewById<EditText>(R.id.nameEditText)
        betraEditText = findViewById(R.id.betragEditText)
        datumEditText = findViewById(R.id.datumEditText)
        kategorieEditText = findViewById(R.id.kategorieEditText)
        waehrungEditText = findViewById(R.id.waehrungEditText)
    }

    private fun checkForEditNote() {
        val previousIntent = intent
        val passedNoteID = previousIntent.getStringExtra(Eintrag.NOTE_EDIT_EXTRA)
        selectedEintrag = passedNoteID?.let { Eintrag.getEintragForName(it) }
        nameEditText!!.setText(selectedEintrag!!.name)
        betraEditText!!.setText(1)
        datumEditText!!.setText(22)
        kategorieEditText!!.setText(selectedEintrag!!.kategorie)
        waehrungEditText!!.setText(selectedEintrag!!.waehrung)
        selectedEintrag = passedNoteID?.let { Eintrag.getEintragForName(it) }

    }

}
