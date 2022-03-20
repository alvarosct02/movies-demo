package com.alvarosct02.moviesdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alvarosct02.moviesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}