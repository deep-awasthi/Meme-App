package com.example.meme_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun loadMeme() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null
                    Response . Listener { response ->
                val url = response.getString( name: "url")
                Glide.with(this).load(url).into(memeImageView);
            },
            Response.ErrorListener {

            }
        )

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)


    }

    fun shareMeme(view: android.view.View) {

    }
    fun nextMeme(view: android.view.View) {
        loadMeme()
    }
}