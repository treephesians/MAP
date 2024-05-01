package edu.skku.MAP.Week3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/*
class week5 {
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
        }
    }

    override fun onRestart() {
        super.onRestart()

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)

        editTextName.text.clear()
        editTextAge.text.clear()
    }
}
 */