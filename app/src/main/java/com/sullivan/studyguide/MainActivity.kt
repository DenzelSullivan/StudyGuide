package com.sullivan.studyguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_LONG).show()
        }

        snackButton.setOnClickListener {
            Snackbar.make(it, getString(R.string.snack_text), Snackbar.LENGTH_LONG).show()
        }
    }
}
