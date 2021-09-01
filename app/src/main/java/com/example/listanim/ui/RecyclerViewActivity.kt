package com.example.listanim.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listanim.R
import com.example.listanim.adapter.SimpleAdapter
import com.example.listanim.databinding.ActivityRecyclerViewBinding
import com.hi.dhl.binding.viewbind
import java.util.*
import android.widget.ArrayAdapter




class RecyclerViewActivity : AppCompatActivity() {

    private val binding by viewbind<ActivityRecyclerViewBinding>()

    private val recyclerView by lazy {
        binding.recyclerView
    }

    private val simpleAdapter by lazy {
        SimpleAdapter()
    }

    private val spinnerList = listOf<String>("slide_in_left","slide_in_right","scale_in_center")

    var anim = R.anim.slide_in_left

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initRecyclerView()
        initSpinner()
    }

    private fun initSpinner() {
        val spAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerList)
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.apply {
            adapter = spAdapter
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Log.d("TAG", "onItemSelected: $p2")
                    when(p2){
                        0 -> anim = R.anim.slide_in_left
                        1 -> anim = R.anim.slide_in_right
                        2 -> anim = R.anim.scale_in_center
                    }
                    setAnimation()
                    simpleAdapter.notifyDataSetChanged()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }

    }


    private fun initRecyclerView() {
        recyclerView.apply {
            setAnimation()
            layoutManager = LinearLayoutManager(context)
            adapter = simpleAdapter.apply {
                setListener(itemClickListener)
            }
        }
    }

    private fun setAnimation(){
        val animation = AnimationUtils.loadAnimation(this, anim)
        val layoutAnimationController = LayoutAnimationController(animation)
        layoutAnimationController.order = LayoutAnimationController.ORDER_NORMAL
        recyclerView.layoutAnimation = layoutAnimationController
    }

    private val itemClickListener = object : SimpleAdapter.ItemTouchListener{
        override fun click(position: Int, resId: Int, view: View) {
            when(resId){
                R.id.icon -> {
                    view.startAnimation(AnimationUtils.loadAnimation(this@RecyclerViewActivity,R.anim.roate_360))
                }
                R.id.title -> {

                }
                else -> {

                }
            }
        }

        override fun itemClick(position: Int) {

        }
    }

}