package ru.opalevapps.unit2_3implicitintentsreceiver

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        var uri: Uri? = intent.data
        if (uri != null) {
            val uri_string = "URI: $uri"
            val textView_uri = findViewById<TextView>(R.id.textView_uri_message)
            textView_uri.text = uri_string
        }
    }
}