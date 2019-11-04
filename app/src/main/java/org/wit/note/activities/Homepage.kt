package org.wit.note.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.wit.note.R

class Homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val mStartActBtn = findViewById<Button>(R.id.startActBtn)

        mStartActBtn.setOnClickListener {
            startActivity(Intent(this@Homepage, NoteListActivity::class.java))
        }
    }
}