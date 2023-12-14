package com.gagan.newsapp.utils.intents

import android.content.Context
import android.content.Intent
import android.net.Uri

object IntentHandler {

    fun shareUrlIntent(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        intent.putExtra(Intent.EXTRA_SUBJECT, "News")
        intent.putExtra(Intent.EXTRA_TEXT, url)
        context.startActivity(Intent.createChooser(intent, "Share this news"))
    }

    fun openUrlIntent(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    }

}
