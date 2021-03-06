package com.example.receiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_TAG_HEADER = "Broadcast1"
        private const val INTENT_TAG_CONTENT = "Broadcast2"
        private const val INTENT_FILTER = "com.skbsc.broadcastnote"
    }

    lateinit var textView: TextView
    private val receiver = NotesReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(receiver, IntentFilter(INTENT_FILTER))

        textView = findViewById(R.id.textView)
        textView.text =
            textView.text.toString() + "\n ${intent.getStringExtra(INTENT_TAG_HEADER)}" + "\n${
                intent.getStringExtra(
                    INTENT_TAG_CONTENT
                )
            }"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}


