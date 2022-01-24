package com.example.receiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotesReceiver(): BroadcastReceiver() {

    companion object{
        private const val RECEIVER_TAG = "Broadcast"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startActivity(Intent(context, MainActivity::class.java).apply {
            putExtra(RECEIVER_TAG, intent?.getStringExtra(RECEIVER_TAG).toString())
        })
    }
}