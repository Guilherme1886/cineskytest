package com.gui.antonio.cinesky.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.gui.antonio.cinesky.R
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.databinding.ItemMovieBinding

class MovieAdapter(val data: List<Movies>, val lambda: (Movies) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class MyViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movies) {
            binding.movie = item
            binding.root.setOnClickListener { lambda(item) }
        }

    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["urlOfMovie"])
        fun urlOfMovie(imageView: ImageView, urlOfMovie: String) {
            Glide.with(imageView).load(urlOfMovie).placeholder(R.drawable.error_404).into(imageView)
        }
    }

}