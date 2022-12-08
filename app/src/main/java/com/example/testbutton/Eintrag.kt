package com.example.testbutton

import java.util.ArrayList
import java.util.Date

class Eintrag {
    var name : String
    var betrag : Float
    var datum : Date
    var kategorie : String
    var waehrung : String
    var deleted : Date?

    constructor(name: String, betrag: Float, datum: Date, kategorie: String,waehrung : String,deleted : Date?)  {
        this.name = name
        this.betrag = betrag
        this.datum = datum
        this.kategorie = kategorie
        this.waehrung = waehrung
        this.deleted  = deleted
    }
    constructor(name: String, betrag: Float, datum: Date, kategorie: String,waehrung : String)  {
        this.name = name
        this.betrag = betrag
        this.datum = datum
        this.kategorie = kategorie
        this.waehrung = waehrung
        deleted = null
    }

    companion object {
        var eintragArrayList = ArrayList<Eintrag>()
        var NOTE_EDIT_EXTRA = "eintragedit"

        fun getEintragForName(passedName: String): Eintrag? {
            for (eintrag in eintragArrayList) {
                if (eintrag.name == passedName) return eintrag
            }
            return null
        }

        fun nonDeletedNotes(): ArrayList<Eintrag> {
            val nonDeleted = ArrayList<Eintrag>()
            for (eintrag in eintragArrayList) {
                if (eintrag.deleted == null) nonDeleted.add(eintrag)
            }
            return nonDeleted
        }
    }
}
