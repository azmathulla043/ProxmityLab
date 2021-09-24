package com.example.proximitylab.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import androidx.activity.viewModels

private val MemsViewModel : MeamsViewModel by viewModels()
private val MemsAdapter = MeamsAdapter()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerview.adapter = MemsAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        MemsViewModel.memesLiveData.observe(this,
            Observer {
                with(MemsAdapter){
                    Memes.clear()
                    Memes.addAll(it)
                    notifyDataSetChanged()
                }
            })

    }
}