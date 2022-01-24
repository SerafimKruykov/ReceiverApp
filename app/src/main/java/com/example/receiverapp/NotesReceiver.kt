package com.example.receiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotesReceiver(): BroadcastReceiver() {

    companion object{
        private const val INTENT_TAG_HEADER = "Broadcast1"
        private const val INTENT_TAG_CONTENT = "Broadcast2"
        private const val TAG_HEADER = "BroadcastHeader"
        private const val TAG_CONTENT = "BroadcastContent"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startActivity(Intent(context, MainActivity::class.java).apply {
            putExtra(INTENT_TAG_HEADER, intent?.getStringExtra(TAG_HEADER).toString())
            putExtra(INTENT_TAG_CONTENT, intent?.getStringExtra(TAG_CONTENT).toString())
        })
    }
}