package org.wit.note.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
  return lastId++
}

class NoteMemStore : NoteStore, AnkoLogger {

  val notes = ArrayList<NoteModel>()

  override fun findAll(): List<NoteModel> {
    return notes
  }

  override fun create(note: NoteModel) {
    note.id = getId()
    notes.add(note)
    logAll()
  }

  override fun update(note: NoteModel) {
    var foundNote: NoteModel? = notes.find { p -> p.id == note.id }
    if (foundNote != null) {
      foundNote.title = note.title
      foundNote.description = note.description
    }
  }

  internal fun logAll() {
    notes.forEach { info("${it}") }
  }
}