package com.alvarosct02.moviesdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alvarosct02.moviesdemo.R
import com.alvarosct02.moviesdemo.databinding.FragmentMovieListBinding
import com.alvarosct02.moviesdemo.utils.ItemSeparatorDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel by viewModel<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        viewModel.fetchPopular()
        viewModel.fetchTopRated()
    }

    private fun setupViews() {
        with(binding.rvPopular) {
            adapter = MovieAdapter()
            val middleSpacePx = resources.getDimensionPixelOffset(R.dimen.size_small)
            addItemDecoration(ItemSeparatorDecoration(middleSpacePx = middleSpacePx))
        }
        with(binding.rvTopRated) {
            adapter = MovieAdapter()
            val middleSpacePx = resources.getDimensionPixelOffset(R.dimen.size_small)
            addItemDecoration(ItemSeparatorDecoration(middleSpacePx = middleSpacePx))
        }

    }
}

