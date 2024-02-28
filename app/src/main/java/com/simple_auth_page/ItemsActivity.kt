package com.simple_auth_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.indigo.first_ui_project.Item

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "book", "Interesting book", "A book where people wrote recipes", 100.0))
        items.add(Item(2, "red_car", "Red car", "Car with red color", 100.0))
        items.add(Item(3, "burger", "Tasty burger", "A burger with many chickens on it", 100.0))
        items.add(Item(4, "computer", "Modern PC", "Computer with many various functionality, which can run new games", 100.0))


    }
}