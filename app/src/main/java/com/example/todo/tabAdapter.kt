package com.example.todo

import android.app.ActivityManager.TaskDescription
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.todo.Fragment.Note
import com.example.todo.Fragment.Task

class tabAdapter(fm: FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        val f1= when(position)
        {
            0->Note()
            1->Task()
            else-> Note()
        }
        return f1
    }
}