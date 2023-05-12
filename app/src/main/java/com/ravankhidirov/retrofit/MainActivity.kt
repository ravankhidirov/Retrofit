package com.ravankhidirov.retrofit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ravankhidirov.retrofit.model.Results
import com.ravankhidirov.retrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSuperHeroes()
    }

    private fun getSuperHeroes() {
        val call: Call<List<Results>>? = RetrofitClient.instance?.getMyApi()?.getsuperHeroes()
        call?.enqueue(object : Callback<List<Results>> {


            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                val myheroList: List<Results> = response.body() as List<Results>
                val oneHeroes = arrayOfNulls<String>(myheroList.size)
                for (i in myheroList.indices) {
                    oneHeroes[i] = myheroList[i].name
                }
                findViewById<ListView>(R.id.myListView).setAdapter(
                    ArrayAdapter<String?>(
                        applicationContext,
                        android.R.layout.simple_list_item_1,
                        oneHeroes
                    )
                )
            }

            override fun onFailure(call: Call<List<Results>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }

        })
    }
}