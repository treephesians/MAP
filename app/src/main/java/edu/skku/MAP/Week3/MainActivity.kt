package edu.skku.MAP.Week3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXT_NAME = "extra_key_name"
        const val EXT_AGE = "extra_key_AGE"
        const val REQUEST_CODE = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewActivity = findViewById<Button>(R.id.buttonNewActivity)
        btnNewActivity.setOnClickListener {
            val editTextName = findViewById<EditText>(R.id.editTextName)
            val editTextAge = findViewById<EditText>(R.id.editTextAge)

            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()

            val intent = Intent(this, Activity2::class.java).apply{
                putExtra(EXT_NAME, name)
                putExtra(EXT_AGE, age)
            }
            startActivity(intent)

            Handler(Looper.getMainLooper()).postDelayed({
                editTextName.text.clear()
                editTextAge.text.clear()
            }, 2000)

        }
    }
}