package com.alvarosct02.moviesdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
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
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (viewModel.popularLoading.checkAndEnable()) return
                    if (!recyclerView.canScrollHorizontally(1)) {
                        viewModel.fetchPopular(loadMore = true)
                    }
                }
            })
        }

        with(binding.rvTopRated) {
            adapter = MovieAdapter()
            val middleSpacePx = resources.getDimensionPixelOffset(R.dimen.size_small)
            addItemDecoration(ItemSeparatorDecoration(middleSpacePx = middleSpacePx))
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (viewModel.topRatedLoading.checkAndEnable()) return
                    if (!recyclerView.canScrollHorizontally(1)) {
                        viewModel.fetchTopRated(loadMore = true)
                    }
                }
            })
        }

    }
}

