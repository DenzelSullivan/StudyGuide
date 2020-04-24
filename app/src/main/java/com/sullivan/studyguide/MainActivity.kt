package com.sullivan.studyguide

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createChannel(getString(R.string.channel_id), "Study Guide Notification")

        toastButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_LONG).show()
        }

        snackButton.setOnClickListener {
            Snackbar.make(it, getString(R.string.snack_text), Snackbar.LENGTH_LONG).show()
        }

        notificationButton.setOnClickListener {
            val notificationManager = ContextCompat.getSystemService(
                this@MainActivity.applicationContext,
                NotificationManager::class.java
            ) as NotificationManager

            notificationManager.sendNotification(
                "Time to Study!!",
                this@MainActivity.applicationContext
            )
        }
    }

    private fun createChannel(channelId: String, channelName: String) {
        val notificationChannel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            setShowBadge(false)
        }
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.description = "Base Notification"

        // for fragment
        /*val notificationManager = requireActivity().getSystemService(
            NotificationManager::class.java
        )*/
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
