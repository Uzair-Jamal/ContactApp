package com.example.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.contactapp.ViewModel.MyViewModel
import com.example.contactapp.data.DatabaseInstance
import com.example.contactapp.presentation.navigation.AppNavigation
import com.example.contactapp.ui.theme.ContactAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dbObject = DatabaseInstance.getDB(this).contactDao()
            ContactAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(innerPadding)){
                        AppNavigation(dbObject)
                    }
                }
            }
        }
    }
}
