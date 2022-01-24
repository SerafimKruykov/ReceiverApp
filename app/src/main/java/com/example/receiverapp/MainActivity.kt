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
        private const val RECEIVER_TAG = "Broadcast"
        private const val INTENT_FILTER = "com.skbsc.broadcastnote"
    }

    lateinit var textView: TextView
    private val receiver = NotesReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(receiver, IntentFilter(INTENT_FILTER))

        textView = findViewById(R.id.textView)
        textView.text = textView.text.toString() + "\n ${intent.getStringExtra(RECEIVER_TAG)}"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}


