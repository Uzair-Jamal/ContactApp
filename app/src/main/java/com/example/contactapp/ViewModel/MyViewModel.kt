package com.example.contactapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.data.tables.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel(val dbObject: ContactDao) : ViewModel() {

    private val _allContacts = MutableStateFlow<List<Contact>>(emptyList())
    val allContacts: StateFlow<List<Contact>> = _allContacts

    init{
        getAllContacts()
    }

    fun getAllContacts(){
        viewModelScope.launch{
            _allContacts.value = dbObject.getAllContacts()
        }
    }

    fun deleteContact(contact: Contact){
        viewModelScope.launch {
            dbObject.deleteContact(contact)
        }
    }

    fun saveEditContact(contact: Contact){
        viewModelScope.launch {
            dbObject.saveEditContact(contact)
        }
    }

    fun test(){
        
    }

}