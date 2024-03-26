package edu.skku.MAP.Week3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ImageView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
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

        var linearLayout = findViewById<LinearLayout>(R.id.sub_layout)
        var btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val layoutInflater: LayoutInflater =
                applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
            layoutInflater.inflate(R.layout.sub_layout, linearLayout, true)

            var img1 = findViewById<ImageView>(R.id.imageView)
            var img2 = findViewById<ImageView>(R.id.imageView2)

            img1.setImageResource(R.drawable.bbq)
            img2.setImageResource(R.drawable.bhc)
        }

        var pizza_btn = findViewById<Button>(R.id.button1)
        var hamburger_btn = findViewById<Button>(R.id.button2)
        var chicken_btn = findViewById<Button>(R.id.button3)
        var items = arrayListOf<Restaurant>()
        var mainList = findViewById<ListView>(R.id.listview)

        pizza_btn.setOnClickListener{
            items = arrayListOf<Restaurant>()
            items.add(Restaurant(R.drawable.domino, "domino"))
            items.add(Restaurant(R.drawable.pizzahut, "pizzahut"))
            items.add(Restaurant(R.drawable.pizzanarachickengongju, "pizzanarachickengongju"))
            val listAdaptor = CustomAdapter(this, items)
            mainList.adapter = listAdaptor
        }

        hamburger_btn.setOnClickListener{
            items = arrayListOf<Restaurant>()
            items.add(Restaurant(R.drawable.burgerking, "burgerking"))
            items.add(Restaurant(R.drawable.lotteria, "lotteria"))
            items.add(Restaurant(R.drawable.mcdonalds, "mcdonalds"))
            items.add(Restaurant(R.drawable.momstouch, "momstouch"))
            val listAdaptor = CustomAdapter(this, items)
            mainList.adapter = listAdaptor
        }

        chicken_btn.setOnClickListener{
            items = arrayListOf<Restaurant>()
            items.add(Restaurant(R.drawable.bbq, "bbq"))
            items.add(Restaurant(R.drawable.bhc, "bhc"))
            items.add(Restaurant(R.drawable.goobne, "goobne"))
            items.add(Restaurant(R.drawable.pizzanarachickengongju, "pizzanarachickengongju"))
            val listAdaptor = CustomAdapter(this, items)
            mainList.adapter = listAdaptor
        }

    }
}
class Restaurant (val id: Int, val name: String)
class CustomAdapter(val context: Context, val items: ArrayList<Restaurant>): BaseAdapter(){
    override fun getCount():Int {
        return items.size
    }
    override fun getItem(position: Int): Any{
        return items.get(position)
    }
    override fun getItemId(position: Int) : Long{
        return 0
    }
    override fun getView(i:Int, cvtView: View?, parent: ViewGroup?):View{
        val inflater: LayoutInflater = LayoutInflater.from(context)
        var view: View = inflater.inflate(R.layout.create_item, null)
        var imgView = view.findViewById<ImageView>(R.id.imageView7)
        var textView = view.findViewById<TextView>(R.id.textView3)
        textView.setText(items.get(i).name)
        imgView.setImageResource(items.get(i).id)

        return view

    }
}