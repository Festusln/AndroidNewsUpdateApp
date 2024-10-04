package com.example.newsupdate.ui.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.entity.Article
import com.example.newsupdate.R
import com.example.newsupdate.ui.adapter.NewsAdapter.*
import com.squareup.picasso.Picasso


class NewsAdapter(private val articlesList : List<Article>) : RecyclerView.Adapter<NewsViewHolder>() {


    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.title)
        val content = view.findViewById<TextView>(R.id.content)
        val author = view.findViewById<TextView>(R.id.author)
        val source = view.findViewById<TextView>(R.id.source)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = articlesList[position]
        holder.title.text = newsItem.title
        holder.content.text = newsItem.content
        if (!newsItem.author.isNullOrEmpty())
            holder.author.text = "Author(s): ${newsItem.author}"

        if (!(newsItem.source?.name.isNullOrEmpty()))
            holder.source.text = "Source: ${newsItem.source?.name?: ""}"

        // Load the image using Picasso
        Picasso.get()
            .load(newsItem.urlToImage)
            .placeholder(R.drawable.ic_placeholder_image) // Optional placeholder
            .error(R.drawable.ic_placeholder_image) // Optional error image
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

}