package com.nomegrupo.aula05

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alert(titulo: String, msg: String, context: Context) {
    AlertDialog.Builder(context)
        .setTitle(titulo)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()
}