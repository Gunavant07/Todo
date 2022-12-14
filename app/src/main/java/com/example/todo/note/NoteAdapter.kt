package com.example.todo.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.DBHelper
import com.example.todo.ModelData
import com.example.todo.R

class NoteAdapter(val activity: FragmentActivity?,val l1: ArrayList<ModelData>) :
    RecyclerView.Adapter<NoteAdapter.ViewData>() {

    class ViewData(itemView: View):RecyclerView.ViewHolder(itemView){

        var title =itemView.findViewById<TextView>(R.id.title)
        var note =itemView.findViewById<TextView>(R.id.note)
        var date =itemView.findViewById<TextView>(R.id.Date)
        var time =itemView.findViewById<TextView>(R.id.Time)
        lateinit var dbHelper: DBHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {

       var view =LayoutInflater.from(activity).inflate(R.layout.notelist,parent,false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {

        holder.title.setText(l1[position].title).toString()
        holder.note.setText(l1[position].data).toString()
        holder.date.setText(l1[position].date).toString()
        holder.time.setText(l1[position].time).toString()
    }
    override fun getItemCount(): Int {
        return l1.size
    }
}