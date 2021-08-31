package com.example.listanim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.listanim.R
import com.example.listanim.databinding.ItemListBinding
import com.hi.dhl.binding.viewbind

/**
 * @ClassName SimpleAdapter
 * @Description TODO
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/8/31 15:01
 */
class SimpleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private lateinit var context: Context
    private var listener:ItemTouchListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return SimpleViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as SimpleViewHolder).binding

        binding.icon.setOnClickListener {
            listener?.click(it,position,binding.icon.id)
        }
        binding.title.apply {
            setOnClickListener {
                listener?.click(it,position,this.id)
            }
            text = position.toString()
        }
    }

    override fun getItemCount(): Int {
        return 100
    }

    inner class SimpleViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding by viewbind<ItemListBinding>()

    }

    interface ItemTouchListener{
        fun click(view:View,position: Int,resId:Int)
    }

    fun setListener(listener:ItemTouchListener){
        this.listener = listener
    }


    /**
     * View依附到Window
     */
    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.clearAnimation()

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_in_scroll))
    }

}