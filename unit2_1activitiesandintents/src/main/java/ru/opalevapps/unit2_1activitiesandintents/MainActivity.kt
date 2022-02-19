package ru.opalevapps.unit2_1activitiesandintents

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "ru.opalevapps.unit2_1activitiesandintents.extra.MESSAGE"
    val TEXT_REQUEST = 1

    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null
    private var mMessageEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = savedInstanceState.getString("reply_text")
            }
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                val reply: String? =
                    data?.getStringExtra(SecondActivity().EXTRA_REPLY) // data?.data.toString()

                // Make the reply head visible.
                mReplyHeadTextView!!.visibility = View.VISIBLE

                // Set the reply and make it visible.
                mReplyTextView!!.text = reply
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        if (mReplyHeadTextView?.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
        }
        outState.putString("reply_text", mReplyTextView?.text.toString())
    }
}