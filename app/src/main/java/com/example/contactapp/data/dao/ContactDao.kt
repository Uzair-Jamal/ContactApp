package com.example.contactapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.contactapp.data.tables.Contact

@Dao
interface ContactDao {

    @Upsert
    fun saveEditContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getAllContacts():List<Contact>

    @Query("SELECT * FROM contact WHERE name LIKE '%' || :name || '%' AND number LIKE '%' || :number || '%' ")
    fun isContactUnique(name: String, number: String): List<Contact>
}