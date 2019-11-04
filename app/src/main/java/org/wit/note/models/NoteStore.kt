package org.wit.note.models

interface NoteStore {
  fun findAll(): List<NoteModel>
  fun create(note: NoteModel)
  fun update(note: NoteModel)
}