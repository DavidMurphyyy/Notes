package org.wit.note.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_note.view.*
import org.wit.note.R
import org.wit.note.models.NoteModel

interface NoteListener {
  fun onNoteClick(note: NoteModel)
}

class NoteAdapter constructor(private var notes: List<NoteModel>,
                                   private val listener: NoteListener) : RecyclerView.Adapter<NoteAdapter.MainHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
    return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_note, parent, false))
  }

  override fun onBindViewHolder(holder: MainHolder, position: Int) {
    val note = notes[holder.adapterPosition]
    holder.bind(note, listener)
  }

  override fun getItemCount(): Int = notes.size

  class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(note: NoteModel, listener: NoteListener) {
      itemView.noteTitle.text = note.title
      itemView.description.text = note.description
      itemView.setOnClickListener { listener.onNoteClick(note) }
    }
  }
}