package com.alvarosct02.moviesdemo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alvarosct02.moviesdemo.databinding.ItemMovieBinding
import com.alvarosct02.moviesdemo.models.Movie

class MovieAdapter :
    ListAdapter<Movie, MovieAdapterViewHolder>(NoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterViewHolder {
        return MovieAdapterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class NoDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }
}


class MovieAdapterViewHolder(
    private val binding: ItemMovieBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(uiState: Movie) {
        binding.item = uiState
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieAdapterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return MovieAdapterViewHolder(binding)
        }
    }
}
