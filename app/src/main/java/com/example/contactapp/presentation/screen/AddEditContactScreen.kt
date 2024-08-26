package com.example.contactapp.presentation.screen

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DismissValue
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.data.tables.Contact

@Preview(showBackground = true)
@Composable
fun AddEditContactScreen(dbObject: ContactDao? = null, navController: NavHostController? = null) {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var number by rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text), maxLines = 1, value = name, onValueChange = {
            name = it
        },
            placeholder = {
                Text(text = "Enter your Name")
            })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email), maxLines = 1, value = email, onValueChange = {
            email = it
        },
            placeholder = {
                Text(text = "Enter your Email")
            })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            maxLines = 1, value = number, onValueChange = {
            number = it
        },
            placeholder = {
                Text(text = "Enter your Number")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (dbObject?.isContactUnique(name, number)?.size!! > 0) {
                    Toast.makeText(context, "This Contact already exists", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    dbObject.saveEditContact(
                        Contact(
                            name = name,
                            email = email,
                            number = number
                        )
                    )
                    navController?.navigateUp()
                }
            } else {
                Toast.makeText(context, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            }


        }) {
            Text(text = "Add Contact")
        }

    }

}