package edu.skku.MAP.Week3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val name = intent.getStringExtra(MainActivity.EXT_NAME)
        val age = intent.getIntExtra(MainActivity.EXT_AGE, -1)

        val textView = findViewById<TextView>(R.id.textView)

        // TextView의 텍스트 변경
        textView.text = "You typed name $name and $age, is that right?"

        val btnYes = findViewById<Button>(R.id.button_YES)
        btnYes.setOnClickListener {

            val intent = Intent(this, Activity3::class.java).apply{
                putExtra(MainActivity.EXT_NAME, name)
                putExtra(MainActivity.EXT_AGE, age)
            }
            startActivity(intent)
        }

        val btnNo = findViewById<Button>(R.id.button_NO)
        btnNo.setOnClickListener {
            setResult(RESULT_OK)  // 결과 설정
            finish()  // 액티비티 종료
        }
    }
}