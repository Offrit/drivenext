package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ViewPagerAdapter(
    private val images: List<Int>, // Список изображений
    private val titles: List<String>, // Список заголовков
    private val subtitles: List<String> // Список подзаголовков
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        // Устанавливаем изображение, заголовок и подзаголовок на основе позиции
        holder.imageView.setImageResource(images[position])
        holder.titleTextView.text = titles[position]
        holder.subtitleTextView.text = subtitles[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
