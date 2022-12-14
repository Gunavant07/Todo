package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabbar.addTab(binding.tabbar.newTab().setIcon(R.drawable.note))
        binding.tabbar.addTab(binding.tabbar.newTab().setIcon(R.drawable.task))


        var tabadapter =tabAdapter(supportFragmentManager)
        binding.viewpager.adapter=tabadapter
        binding.viewpager.setOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                binding.tabbar
            )
        )
        binding.tabbar.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }

}