package edu.skku.MAP.Week3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val name = intent.getStringExtra(MainActivity.EXT_NAME)
        val age = intent.getIntExtra(MainActivity.EXT_AGE, -1)

        Toast.makeText(
            applicationContext,
            "Welcome, ${name}(${age} years old)!",
            Toast.LENGTH_SHORT
        ).show()
    }
}