package com.example.todo.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.ModelData
import com.example.todo.R
import com.example.todo.note.NoteAdapter

class TaskAdapter(val activity: FragmentActivity?,val l1: ArrayList<ModelData>) :
    RecyclerView.Adapter<TaskAdapter.ViewData>() {
    class ViewData(itemView: View):RecyclerView.ViewHolder(itemView){
        var task=itemView.findViewById<TextView>(R.id.txttask)
        var Date=itemView.findViewById<TextView>(R.id.Date)
        var checkbox=itemView.findViewById<CheckBox>(R.id.checkbox)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(activity).inflate(R.layout.tasklist,parent,false)
        return ViewData(view)

    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.task.setText(l1[position].title).toString()
    }
    override fun getItemCount(): Int {
        return l1.size
    }
}