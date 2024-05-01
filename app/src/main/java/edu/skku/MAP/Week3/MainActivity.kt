package edu.skku.MAP.Week3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch(){
                textView.text = task().await()
            }
        }
    }
    fun task() = CoroutineScope(Dispatchers.IO).async{

        val totalIterations = 100_000_000
        val updateInterval = 1_000_000
        var insideCircleCount = 0
        val textView = findViewById<TextView>(R.id.textView)

        for (i in 1..totalIterations / updateInterval) {
            for (j in 1..updateInterval){
                val x = Math.random()
                val y = Math.random()

                if (x * x + y * y <= 1.0) {
                    insideCircleCount++
                }
            }
            CoroutineScope(Dispatchers.Main).launch(){
                textView.text = task2(i, insideCircleCount).await()
            }
        }
        Thread.sleep(1)
        "Done!\nEstimation: ${String.format("%.6f", 4.0 * insideCircleCount / totalIterations)}"
    }

    fun task2(progress:Int, insideCircleCount:Int) = CoroutineScope(Dispatchers.IO).async {

        val updateInterval = 1_000_000
        val piEstimation = 4.0 * insideCircleCount / (progress * updateInterval)
        val piEstimation6f = String.format("%.6f", piEstimation)

        "Done $progress%...\nCurrent estimation: ${piEstimation6f}"
    }
}