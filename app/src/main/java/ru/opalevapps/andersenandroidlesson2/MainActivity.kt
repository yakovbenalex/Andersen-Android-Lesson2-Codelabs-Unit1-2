package ru.opalevapps.andersenandroidlesson2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName

    private var mCount = 0
    private var tvShowCount: TextView? = null
    private var btnZero: Button? = null
    private var btnCount: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "MainActivity started")

        tvShowCount = findViewById(R.id.tv_show_count)
        btnZero = findViewById(R.id.button_zero)
        btnCount = findViewById(R.id.button_count)
    }

    fun showToast(view: View) =
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()

    fun countUp(view: View) {
        //increase count value
        tvShowCount!!.text = Integer.toString(++mCount)

        // change count button color by odd or even value
        if (mCount % 2 == 0)
            btnCount!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        else btnCount!!.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))

        // change zero button color
        if (mCount != 0) {
            btnZero!!.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
            btnZero!!.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    fun resetToZero(view: View) {
        // reset count value
        mCount = 0
        tvShowCount!!.text = "0"

        // set buttons color
        // button count
        btnCount!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        // button zero
        btnZero!!.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
        btnZero!!.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}