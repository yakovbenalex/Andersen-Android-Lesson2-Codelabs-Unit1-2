package ru.opalevapps.andersenandroidlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // get intent that launched this activity
        val intent = intent
        // get data from intent
        val message = intent.getIntExtra(MainActivity().EXTRA_MESSAGE, 0)

        // put message into TextView
        val textView_hello_count: TextView = findViewById(R.id.textView_hello_count)
        textView_hello_count.text = "${getString(R.string.text_hello)}\n$message"
    }
}