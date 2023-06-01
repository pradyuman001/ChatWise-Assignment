package com.example.chatwisedemo.activity

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.chatwisedemo.databinding.ActivityMainBinding
import com.example.chatwisedemo.model.ChatWiseModelItem
import com.example.chatwisedemo.viewModel.ChatWiseViewModel

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var mainList = arrayListOf<ChatWiseModelItem>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkInternet()


        sendToImageViewActivity()

    }

    private fun checkInternet() {
        val activeNetwork =
            (getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo

        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting) {
            gteDataFromApi()
        } else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendToImageViewActivity() {
        binding.activityMainViewImagesButton.setOnClickListener {

            startActivity(Intent(this, ImageViewActivity::class.java))
        }
    }

    private fun gteDataFromApi() {
        val userViewModel = ViewModelProvider(this)[ChatWiseViewModel::class.java]
        userViewModel.dataList.observe(this) {

            Log.e("TAG", "onCreate==========: ${it.size}")
            mainList.addAll(it)
            Log.e("TagMainActivity", "onCreate: $mainList")
        }
    }
}
