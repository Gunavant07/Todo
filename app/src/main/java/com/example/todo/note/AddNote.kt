package com.example.todo.note

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.todo.DBHelper
import com.example.todo.Fragment.Note
import com.example.todo.ModelData
import com.example.todo.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.*

class AddNote : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    lateinit var dbHelper: DBHelper
    var l1 = arrayListOf<ModelData>()
    var cal = Calendar.getInstance()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
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
        binding.txtdate.setOnClickListener {
            DatePickerDialog(
                this@AddNote,
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
        binding.txtdate.text = sdf.format(cal.time)
    }

    private fun initClick() {
        binding.back.setOnClickListener {

            val intent = Intent(this,Note::class.java)
            startActivity(intent)
        }
        binding.save.setOnClickListener {

            dbHelper.insertData(binding.edttitle.text.toString(),binding.edtdata.text.toString(),
                binding.txtdate.text.toString(),binding.txttime.text.toString())
            l1 =dbHelper.ReadData()
            finish()
        }
    }
}
