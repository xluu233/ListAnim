package com.example.listanim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listanim.databinding.ActivityMainBinding
import com.example.listanim.ui.CardViewActivity
import com.example.listanim.ui.RecyclerViewActivity
import com.example.listanim.ui.ValueAnimatorActivity
import com.hi.dhl.binding.viewbind

class MainActivity : AppCompatActivity() {

    private val binding by viewbind<ActivityMainBinding>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClick()
    }

    private fun initClick() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, CardViewActivity::class.java))
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        binding.button3.setOnClickListener {
            startActivity(Intent(this, ValueAnimatorActivity::class.java))
        }
    }


}