package com.example.proximitylab.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proximitylab.Model.Meme
import com.example.proximitylab.Network.ApiClient
import com.example.proximitylab.Network.ApiInterface
import com.example.proximitylab.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class MainActivity : AppCompatActivity() {
    var MemsData: ArrayList<Meme> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // API call

        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.fetchMems().enqueue(object : Callback<ArrayList<Meme>> {
            override fun onResponse(call: Call<ArrayList<Meme>>?, response: Response<ArrayList<Meme>>?) {
                MemsData = response?.body()!!
                recyclerView.adapter = MemeRecycleAdapter(response?.body()!!, this@MainActivity)
            }

            override fun onFailure(call: Call<ArrayList<Meme>>?, t: Throwable?) {
            }
        })



    }
}