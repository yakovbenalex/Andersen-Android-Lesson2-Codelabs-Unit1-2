package ru.opalevapps.andersenandroidlesson2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName

    private var mCount = 0
    private var tvShowCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "MainActivity started")

        tvShowCount = findViewById(R.id.tv_show_count)
    }

    fun showToast(view: View) =
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()

    fun countUp(view: View) {
        tvShowCount!!.text = Integer.toString(++mCount)
    }
}