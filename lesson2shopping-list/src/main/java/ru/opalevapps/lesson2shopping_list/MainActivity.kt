package ru.opalevapps.lesson2shopping_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val ITEM_REQUEST = 1
    val LOG_TAG = "ShoppingList"

    // for views
    var textView_id_array: IntArray? = null  // to add all needed TextViews
    var textView_shop_item: TextView? = null  // tmp link to assign each TextViews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fill array of textViews id
        textView_id_array = intArrayOf(
            R.id.textView_shop_item1,
            R.id.textView_shop_item2,
            R.id.textView_shop_item3,
            R.id.textView_shop_item4,
            R.id.textView_shop_item5,
            R.id.textView_shop_item6,
            R.id.textView_shop_item7,
            R.id.textView_shop_item8,
            R.id.textView_shop_item9,
            R.id.textView_shop_item10,
        )
    }

    // open shopping list Activity to adding shopping item
    fun openItemList(view: View) {
        var intent = Intent(this, ShoppingListActivity::class.java)
        startActivityForResult(intent, ITEM_REQUEST)
    }

    // clear shopping list
    fun clearShoppingList(view: View) {
        // pass all shopping textViews and empty them
        for (id in textView_id_array!!) {
            textView_shop_item = findViewById(id)
            textView_shop_item?.text = ""
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Test for the right intent reply.
        if (requestCode == ITEM_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                val reply: String? = data?.getStringExtra(ShoppingListActivity().EXTRA_ITEM)

                // pass all shopping textViews and find empty to adding shopping item into it
                var textView_count = 0
                for (id in textView_id_array!!) {
                    textView_shop_item = findViewById(id)
                    if (textView_shop_item?.text == "") {
                        textView_shop_item?.text = reply
                        break
                    }
                    textView_count++
                }

                // check if all textViews not empty
                if (textView_count >= textView_id_array!!.count())
                    Toast.makeText(
                        this,
                        getString(R.string.label_all_textViews_occupied),
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }
}