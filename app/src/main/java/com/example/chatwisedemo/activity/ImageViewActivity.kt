package com.example.chatwisedemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatwisedemo.activity.MainActivity.Companion.mainList
import com.example.chatwisedemo.adapter.ImageViewAdapter
import com.example.chatwisedemo.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        loader()
    }

    private fun loader() {
        if (mainList != null) {
            binding.activityImageViewProgressBar.isVisible = false
        }
    }

    private fun setUpRecyclerView() {
        val adapter = ImageViewAdapter(this, mainList)
        val layoutManager = LinearLayoutManager(this)
        binding.apply {
            activityImageViewRecyclerView.layoutManager = layoutManager
            activityImageViewRecyclerView.adapter = adapter
        }
    }
}