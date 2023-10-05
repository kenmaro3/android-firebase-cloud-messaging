package com.example.cloudmessagingandroid

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.cloudmessagingandroid.View.FirebaseMessagingScreen
import com.example.cloudmessagingandroid.ui.theme.CloudMessagingAndroidTheme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d("FCM", token.toString())
            Toast.makeText(baseContext, token.toString(), Toast.LENGTH_SHORT).show()
        })

        super.onCreate(savedInstanceState)
        setContent {
            CloudMessagingAndroidTheme {
                FirebaseMessagingScreen()
            }
        }
    }
}
