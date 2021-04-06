package com.alvarengadev.alvaflix.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.databinding.FragmentDetailsBinding
import com.alvarengadev.alvaflix.extensions.createToast
import com.alvarengadev.alvaflix.extensions.layoutHorizontal
import com.alvarengadev.alvaflix.utils.FormatDate
import com.alvarengadev.alvaflix.view.details.adapter.MovieSimilarAdapter
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val viewModel: DetailsViewModel by viewModel()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val detailsBinding = FragmentDetailsBinding.bind(view)
        initComponents(detailsBinding)
    }

    private fun initComponents(detailsBinding: FragmentDetailsBinding) {
        detailsBinding.ibDetailsBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val movie = args.movie

        detailsBinding.tvDetailsTitleMovie.text = movie.title
        detailsBinding.tvDetailsValueRatingMovie.text = movie.rating
        detailsBinding.tvDetailsYearMovie.text = getString(R.string.label_date_movies_details, FormatDate.getLongDate(movie.date))
        detailsBinding.tvDetailsDescriptionMovie.text = movie.description

        showIconMyList(movie, detailsBinding)

        val imagePoster = movie.posterDetails ?: movie.poster

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${imagePoster}")
            .into(detailsBinding.ivDetailsPosterMovie)

        viewModel.getListMovieSimilar(movie.id)
        viewModel.listMovieSimilarData.observe(viewLifecycleOwner, { listMoviesSimilar ->
            val movieSimilarAdapter = MovieSimilarAdapter(listMoviesSimilar)

            movieSimilarAdapter.setOnClickListener(object : MovieOnClickListener {
                override fun onItemClick(movie: Movie) {
                    val directions = DetailsFragmentDirections.actionDetailsFragmentSelf(movie)
                    findNavController().navigate(directions)
                }
            })

            if (listMoviesSimilar.isNullOrEmpty()) {
                detailsBinding.tvDetailsSimilarMovies.visibility = View.GONE
                detailsBinding.rcyDetailsSimilarMovies.visibility = View.GONE
            } else {
                detailsBinding.tvDetailsSimilarMovies.visibility = View.VISIBLE
                detailsBinding.rcyDetailsSimilarMovies.apply {
                    visibility = View.VISIBLE
                    adapter = movieSimilarAdapter
                    layoutManager = this.layoutHorizontal()
                }
            }
        })
    }

    private fun showIconMyList(
        movie: Movie,
        detailsBinding: FragmentDetailsBinding
    ) {
        viewModel.isMovieFavorite(movie)
        viewModel.isMovieFavoriteData.observe(viewLifecycleOwner, { isFavorite ->
            if (isFavorite) {
                detailsBinding.btnLinearDetailsMyList.setOnClickListener(deleteMovieFavorite(movie, detailsBinding))
                detailsBinding.ivDetailsIconMyList.setImageResource(R.drawable.ic_check)
            } else {
                detailsBinding.btnLinearDetailsMyList.setOnClickListener(addMovieFavorite(movie, detailsBinding))
                detailsBinding.ivDetailsIconMyList.setImageResource(R.drawable.ic_plus)
            }
        })
    }

    private fun addMovieFavorite(movie: Movie, detailsBinding: FragmentDetailsBinding) = View.OnClickListener {
        viewModel.insertMovieFavorite(movie)
        detailsBinding.ivDetailsIconMyList.setImageResource(R.drawable.ic_check)
        requireContext().createToast("Add in My List")
    }

    private fun deleteMovieFavorite(movie: Movie, detailsBinding: FragmentDetailsBinding) = View.OnClickListener {
        viewModel.deleteMovieFavorite(movie)
        detailsBinding.ivDetailsIconMyList.setImageResource(R.drawable.ic_plus)
        requireContext().createToast("Delete in My List")
    }
}