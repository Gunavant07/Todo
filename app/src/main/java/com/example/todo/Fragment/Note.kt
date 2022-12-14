package com.example.todo.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.todo.*
import com.example.todo.databinding.FragmentNoteBinding
import com.example.todo.note.AddNote
import com.example.todo.note.NoteAdapter

class Note : Fragment() {

    lateinit var binding: FragmentNoteBinding
    lateinit var noteAdapter : NoteAdapter
    var l1 = arrayListOf<ModelData>()
    lateinit var dbHelper:DBHelper


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding=FragmentNoteBinding.bind(inflater.inflate(R.layout.fragment_note,container,false))
        initClick()
        rvSetup(l1)
        dbHelper=DBHelper(activity)
        return binding.root
    }

    private fun initClick() {
        binding.btnaddnote.setOnClickListener {

            var intent = Intent(activity, AddNote::class.java)
            startActivity(intent)
        }
    }
    private fun rvSetup(l1:ArrayList<ModelData>) {
        noteAdapter = NoteAdapter(activity,l1)
        val lm = GridLayoutManager(activity,2)
        binding.rcy.layoutManager = lm
        binding.rcy.adapter =noteAdapter
    }
    override fun onStart() {
        super.onStart()
        l1 = dbHelper.ReadData()
        rvSetup(l1)
    }


}