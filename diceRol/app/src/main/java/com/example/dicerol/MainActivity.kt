package com.example.dicerol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dicerol.databinding.ActivityMainBinding;



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = DiceViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
