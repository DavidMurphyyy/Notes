package org.wit.note.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_note.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.note.R
import org.wit.note.main.MainApp
import org.wit.note.models.NoteModel

class NoteActivity : AppCompatActivity(), AnkoLogger {

  var note = NoteModel()
  lateinit var app: MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_note)
    toolbarAdd.title = title
    setSupportActionBar(toolbarAdd)
    info("Note Activity started..")

    app = application as MainApp

    if (intent.hasExtra("note_edit")) {
      note = intent.extras?.getParcelable<NoteModel>("note_edit")!!
      noteTitle.setText(note.title)
      description.setText(note.description)
    }

    btnAdd.setOnClickListener() {
      note.title = noteTitle.text.toString()
      note.description = description.text.toString()
      if (note.title.isNotEmpty()) {
        app.notes.create(note.copy())
        info("add Button Pressed: $noteTitle")
        setResult(AppCompatActivity.RESULT_OK)
        finish()
      } else {
        toast("Please Enter a title")
      }
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_note, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item?.itemId) {
      R.id.item_cancel -> {
        finish()
      }
    }
    return super.onOptionsItemSelected(item)
  }
}

