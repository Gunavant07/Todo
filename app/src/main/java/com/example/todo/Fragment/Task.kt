package com.example.todo.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.DBHelper
import com.example.todo.ModelData
import com.example.todo.R
import com.example.todo.databinding.FragmentTaskBinding
import com.example.todo.note.AddNote
import com.example.todo.task.AddTask
import com.example.todo.task.TaskAdapter


class Task : Fragment() {

    lateinit var binding:FragmentTaskBinding
    lateinit var dbHelper:DBHelper
    lateinit var taskAdapter: TaskAdapter
    var l1 = arrayListOf<ModelData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentTaskBinding.bind(inflater.inflate(R.layout.fragment_task,container,false))
        initClick()
        rvSetup(l1)
        dbHelper= DBHelper(activity)
        return binding.root
    }

    private fun initClick() {
        binding.btnaddtask.setOnClickListener {
            var intent = Intent(activity, AddTask::class.java)
            startActivity(intent)
        }
    }

    private fun rvSetup(l1:ArrayList<ModelData>) {
         taskAdapter= TaskAdapter(activity,l1)
        val lm = LinearLayoutManager(activity)
        binding.rcy1.layoutManager = lm
        binding.rcy1.adapter = taskAdapter
    }
    override fun onStart() {
        super.onStart()
        l1 = dbHelper.ReadData()
        rvSetup(l1)
    }
}