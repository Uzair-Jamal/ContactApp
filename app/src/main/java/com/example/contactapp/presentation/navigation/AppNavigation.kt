package com.example.contactapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.presentation.screen.AddEditContactScreen
import com.example.contactapp.presentation.screen.MainScreen

@Composable
fun AppNavigation(dbObject: ContactDao) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ContactScreen) {

        composable<ContactScreen> {
            MainScreen(dbObject, navController )
        }

        composable<SaveEditScreen> {
            AddEditContactScreen(dbObject, navController)
        }

    }

}