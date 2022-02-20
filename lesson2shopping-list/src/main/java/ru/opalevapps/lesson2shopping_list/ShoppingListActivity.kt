package ru.opalevapps.lesson2shopping_list

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class ShoppingListActivity : AppCompatActivity() {
    val EXTRA_ITEM = "shoppingList.extra.item"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shooping_list)

        // find views by id
        val listView = findViewById<ListView>(R.id.listView_shopping_list)

        // data array of shopping items
        val shopItems = arrayOf("Bread", "Cheese", "Milk", "Juice", "Water", "Ice-cream",
            "Potato", "Carrot", "Onion", "Apples", "Banana", "Lemon", "Mutton")

        // data adapter for listView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, shopItems)
        listView.adapter = adapter

        // handle list items click
        listView.setOnItemClickListener { parent, view, position, id ->
            val element = adapter.getItem(position)  // The item that was clicked

            val replyIntent = Intent()  // new intent to reply message
            replyIntent.putExtra(EXTRA_ITEM, element)
            setResult(RESULT_OK, replyIntent)
            finish()
        }
    }
}