package com.example.todo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbtask(context: Context): SQLiteOpenHelper(context,"ToDo.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE todotask(id INTEGER PRIMARY KEY AUTOINCREMENT,task TEXT,date TEXT,time TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun insertData(t1: String,d2: String,a1: String){

        var db =writableDatabase

        var contentValue = ContentValues()
        contentValue.put("task",t1)
        contentValue.put("date",d2)
        contentValue.put("time",a1)

        db.insert("todo",null,contentValue)
    }
    @SuppressLint("Range")
    fun ReadData():ArrayList<TaskData>{

        var db =readableDatabase
        var query = "SELECT * FROM todo"
        var cursor=db.rawQuery(query,null)
        var list= arrayListOf<TaskData>()
        if(cursor.moveToFirst())
        {
            do{
                var id = cursor.getString(cursor.getColumnIndex("id")).toString()
                var task =cursor.getString(cursor.getColumnIndex("task")).toString()
                var date = cursor.getString(cursor.getColumnIndex("date")).toString()
                var time = cursor.getString(cursor.getColumnIndex("time")).toString()

                var d1 = TaskData(id,task,date,time)
                list.add(d1)
            }while (cursor.moveToNext())
        }
        return list
    }
    fun delete(id :String){
        var db = writableDatabase
        db.delete("todo","id = $id",null)
    }
    fun update(id :String,t1:String,d1:String,d2:String,a1:String){
        var db =writableDatabase

        var contentValue = ContentValues()
        contentValue.put("id",id)
        contentValue.put("title",t1)
        contentValue.put("data",d1)
        contentValue.put("date",d2)
        contentValue.put("time",a1)

        db.update("todo",contentValue,"id = $id",null)
    }
}