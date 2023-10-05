package com.example.cloudmessagingandroid

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.cloudmessagingandroid.View.FirebaseMessagingScreen
import com.example.cloudmessagingandroid.ui.theme.CloudMessagingAndroidTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CloudMessagingAndroidTheme {
                FirebaseMessagingScreen()
            }
        }
    }
}
