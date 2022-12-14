package com.example.todo.task

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.todo.DBHelper
import com.example.todo.Fragment.Note
import com.example.todo.ModelData
import com.example.todo.R
import com.example.todo.databinding.ActivityAddNoteBinding
import com.example.todo.databinding.ActivityAddTaskBinding
import java.text.SimpleDateFormat
import java.util.*

class AddTask : AppCompatActivity() {
    lateinit var binding: ActivityAddTaskBinding
    lateinit var dbHelper: DBHelper
    var l1 = arrayListOf<ModelData>()
    var cal = Calendar.getInstance()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper= DBHelper(this)
        initClick()
        DatePick()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun DatePick() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        binding.date.setOnClickListener {
            DatePickerDialog(
                this@AddTask,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateDateInView() {
        val myFormat = "dd/MM/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        sdf.format(cal. time).also { binding.date.text = it }
    }
    private fun initClick() {
        binding.back.setOnClickListener {

            val intent = Intent(this, Note::class.java)
            startActivity(intent)
        }
    }

}