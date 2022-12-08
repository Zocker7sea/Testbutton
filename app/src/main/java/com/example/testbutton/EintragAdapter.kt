package com.example.testbutton

import android.content.Context
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

class EintragAdapter(context: Context?, eintraege: List<Eintrag?>?) : ArrayAdapter<Eintrag?>(
    context!!, 0, eintraege!!
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val eintrag = getItem(position)
        if (convertView == null) convertView =
            LayoutInflater.from(context).inflate(R.layout.eintrag_cell, parent, false)
        val name = convertView!!.findViewById<TextView>(R.id.cellName)
        val betrag = convertView.findViewById<TextView>(R.id.cellBetrag)
        val date = convertView.findViewById<TextView>(R.id.cellDatum)
        name.text = eintrag!!.name
        betrag.text = eintrag.kategorie
        date.text = eintrag.waehrung
        return convertView
    }
}