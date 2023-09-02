package com.undivided.notes.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.undivided.notes.database.NoteDatabaseHelper
import com.undivided.notes.databinding.ActivityAddNoteBinding
import com.undivided.notes.model.Note

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        db = NoteDatabaseHelper(this)

        binding.btnSave.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val title = binding.etTitle.text.toString()
        val content = binding.etContent.text.toString()
        val note = Note(0, title, content)
        db.insertNote(note)
        finish()
    }

}