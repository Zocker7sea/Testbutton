package com.example.testbutton

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.EditText
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class SQLiteManager(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val sql: StringBuilder
        sql = StringBuilder()
            .append("CREATE TABLE ")
            .append(TABLE_NAME)
            .append("(")
            .append(COUNTER)
            .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(NAME_FIELD)
            .append(" TEXT, ")
            .append(BETRAG_FIELD)
            .append(" FLOAT, ")
            .append(DATUM_FIELD)
            .append(" TEXT, ")
            .append(KATEGORIE_FIELD)
            .append(" TEXT,)")
            .append(WAEHRUNGS_FIELD)
            .append(" TEXT")
        sqLiteDatabase.execSQL(sql.toString())
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        switch (oldVersion)
//        {
//            case 1:
//                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + NEW_COLUMN + " TEXT");
//            case 2:
//                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + NEW_COLUMN + " TEXT");
//        }
    }

    fun addEintragToDatabase(eintrag: Eintrag) {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME_FIELD, eintrag.name)
        contentValues.put(BETRAG_FIELD, eintrag.betrag)
        contentValues.put(DATUM_FIELD, getStringFromDate(eintrag.datum))
        contentValues.put(KATEGORIE_FIELD, eintrag.kategorie)
        contentValues.put(WAEHRUNGS_FIELD, eintrag.waehrung)
        contentValues.put(DELETED_FIELD, getStringFromDate(eintrag.deleted))
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues)
    }

    fun populateEintraegeList() {
        val sqLiteDatabase = this.readableDatabase
        sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null).use { result ->
            if (result.count != 0) {
                while (result.moveToNext()) {
                    val name = result.getString(1)
                    val betrag = result.getFloat(2)
                    val stringDatum = result.getString(3)
                    val datum = getDateFromString(stringDatum)
                    val kategorie = result.getString(4)
                    val  waehrung = result.getString(5)
                    val stringDeleted = result.getString(6)
                    val deleted = getDateFromString(stringDeleted)
                    val eintrag = datum?.let {
                        Eintrag(name, betrag,
                            it, kategorie, waehrung,deleted)
                    }
                    if (eintrag != null) {
                        Eintrag.eintragArrayList.add(eintrag)
                    }
                }
            }
        }
    }

    fun updateNoteInDB(eintrag: Eintrag) {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME_FIELD, eintrag.name)
        contentValues.put(BETRAG_FIELD, eintrag.betrag)
        contentValues.put(DATUM_FIELD, getStringFromDate(eintrag.datum))
        contentValues.put(KATEGORIE_FIELD, eintrag.kategorie )
        contentValues.put(WAEHRUNGS_FIELD,eintrag.waehrung)
        contentValues.put(DELETED_FIELD, getStringFromDate(eintrag.deleted))
        sqLiteDatabase.update(
            TABLE_NAME,
            contentValues,
            NAME_FIELD + " =? ",
            arrayOf(eintrag.name)
        )
    }

    private fun getStringFromDate(date: Date?): String? {
        return if (date == null) null else dateFormat.format(date)
    }

    private fun getDateFromString(string: String): Date? {
        return try {
            dateFormat.parse(string)
        } catch (e: ParseException) {
            null
        } catch (e: NullPointerException) {
            null
        }
    }
    fun getFloat(view: EditText): Float {
        return getFloat(view.text.toString())
    }
    fun getFloat(intString: String): Float {
        var res : Float = 0f
        try {
            res = java.lang.Float.valueOf(intString.toString())

        } catch (e: java.lang.NumberFormatException) {
            e.printStackTrace()
        }
        return res
    }



    companion object {
        private var sqLiteManager: SQLiteManager? = null
        private const val DATABASE_NAME = "EintragDB"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "Eintrag"
        private const val COUNTER = "Counter"
        private const val NAME_FIELD = "Edeka"
        private const val BETRAG_FIELD = "10.20"
        private const val DATUM_FIELD = "10-10-2020"
        private const val KATEGORIE_FIELD = "Lebensmittel"
        private const val WAEHRUNGS_FIELD = "$"
        private const val DELETED_FIELD = " deleted"

        @SuppressLint("SimpleDateFormat")
        val dateFormat: DateFormat = SimpleDateFormat("dd-mm-yyyy HH:mm:ss")
        fun instanceOfDatabase(context: Context?): SQLiteManager? {
            if (sqLiteManager == null) sqLiteManager = SQLiteManager(context)
            return sqLiteManager
        }
    }
}
