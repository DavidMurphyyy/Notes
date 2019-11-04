package org.wit.note.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.note.models.NoteMemStore

class MainApp : Application(), AnkoLogger {

  val notes = NoteMemStore()

  override fun onCreate() {
    super.onCreate()
    info("Note started")
  }
}