package com.example.taskmanagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanagerapp.adapter.NoteAdapter
import com.example.taskmanagerapp.database.NoteDatabase
import com.example.taskmanagerapp.databinding.ActivityMainBinding
import com.example.taskmanagerapp.repositary.NoteRepository
import com.example.taskmanagerapp.viewmodel.NoteViewModel
import com.example.taskmanagerapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel


    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NoteDatabaseHelper
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setupViewModel()

    }

    private fun setupViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}