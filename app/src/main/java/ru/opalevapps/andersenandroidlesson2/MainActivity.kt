package ru.opalevapps.andersenandroidlesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "ru.opalevapps.andersenandroidlesson2.extra.MESSAGE"

    private var mCount = 0
    private var tvShowCount: TextView? = null
    private var btnCount: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "MainActivity started")

        tvShowCount = findViewById(R.id.tv_show_count)
        btnCount = findViewById(R.id.button_count)
    }

    fun showToast(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        val message = mCount  //.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    fun countUp(view: View) {
        //increase count value
        tvShowCount!!.text = (++mCount).toString()
    }
}