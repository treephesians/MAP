package edu.skku.MAP.Week3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ImageView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var counter = 0
        var textview = findViewById<TextView>(R.id.textView)
        var imageView = findViewById<ImageView>(R.id.imageView)
        var left_btn = findViewById<Button>(R.id.button)
        var right_btn = findViewById<Button>(R.id.button2)

        textview.text = "pizza"
        imageView.setImageResource(R.drawable.pizza)

        right_btn.setOnClickListener{
            counter += 1
            when(counter){
                1 -> {
                    textview.text = "chicken"
                    imageView.setImageResource(R.drawable.chicken)
                }
                2 -> {
                    textview.text = "hamburger"
                    imageView.setImageResource(R.drawable.hamburger)
                }
                3 -> {
                    textview.text = "ramen"
                    imageView.setImageResource(R.drawable.ramen)
                }
                4 -> {
                    Toast.makeText(this@MainActivity, "Last Image", Toast.LENGTH_LONG).show()
                    counter -= 1
                }
            }
        }



        left_btn.setOnClickListener{
            counter -= 1
            when(counter){
                0 -> {
                    textview.text = "pizza"
                    imageView.setImageResource(R.drawable.pizza)
                }
                1 -> {
                    textview.text = "chicken"
                    imageView.setImageResource(R.drawable.chicken)
                }
                2 -> {
                    textview.text = "hamburger"
                    imageView.setImageResource(R.drawable.hamburger)
                }
                -1 -> {
                    Toast.makeText(this@MainActivity, "First Image", Toast.LENGTH_LONG).show()
                    counter += 1
                }
            }

        }
    }
}