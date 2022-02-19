package ru.opalevapps.unit2_1activitiesandintents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    val EXTRA_REPLY = "ru.opalevapps.unit2_1activitiesandintents.extra.REPLY"
    private var mReply: EditText? = null
    val LOG_TAG = SecondActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // views init
        mReply = findViewById(R.id.editText_second)

        // get intent that launched this activity
        val intent = intent
        // get data from intent
        val message = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)

        // put message into TextView
        val textView: TextView = findViewById(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View) {
        val reply: String = mReply?.text.toString()  // get string from edit text
        val replyIntent = Intent()  // new intent to reply message
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()

        Log.d(LOG_TAG, "End SecondActivity")
    }
}