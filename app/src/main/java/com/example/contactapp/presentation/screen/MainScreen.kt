package com.example.contactapp.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.presentation.navigation.SaveEditScreen

@Composable
fun MainScreen(dbObject: ContactDao, navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton =
        {
            FloatingActionButton(
                onClick = { navController.navigate(SaveEditScreen)}) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
        }
        }) {

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            items(dbObject.getAllContacts()) { contact ->
                Card(modifier = Modifier.fillMaxSize()) {
                    Text(text = contact.name)
                    Text(text = contact.email)
                    Text(text = contact.number)
                    IconButton(onClick = { dbObject.deleteContact(contact) }) {
                        Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
