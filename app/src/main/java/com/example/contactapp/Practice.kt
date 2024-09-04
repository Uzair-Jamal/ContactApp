package com.example.contactapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){

    GlobalScope.launch(Dispatchers.IO){
        delay(4000)
    }

}