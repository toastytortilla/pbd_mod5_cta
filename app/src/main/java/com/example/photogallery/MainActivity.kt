package com.example.photogallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Example image URLs
        val images = listOf(
            ImageItem("https://cdn.dogsplanet.com/wp-content/uploads/2022/09/two-chocolate-and-tan-dachshunds-with-yellow-flowers.jpg"),
            ImageItem("https://i.pinimg.com/originals/f4/4e/ba/f44ebae42ce834ba9361530246b45055.jpg"),
            ImageItem("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F57%2F2d%2F72%2F572d729591618688d70cb64705c906b6.jpg&f=1&nofb=1&ipt=2fbeabe6c199230e20b9c66c989a02b4e1cc72da9f8c177f0547db733ed912c4&ipo=images")
        )

        imageAdapter = ImageAdapter(this, images)
        recyclerView.adapter = imageAdapter
    }
}

