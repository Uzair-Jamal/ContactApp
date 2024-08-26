package com.example.contactapp.data

import android.content.Context
import androidx.room.Room
import com.example.contactapp.data.database.ContactDatabase

object DatabaseInstance {
    var db: ContactDatabase ?= null
    fun getDB(context: Context): ContactDatabase {
        if(db==null){
        db = Room.databaseBuilder(context, ContactDatabase::class.java, "contact_db")
            .allowMainThreadQueries()
            .build()
        }
        return db!!
    }
}