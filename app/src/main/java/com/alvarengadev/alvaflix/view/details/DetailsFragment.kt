package com.alvarengadev.alvaflix.view.details

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.extensions.createToast
import com.alvarengadev.alvaflix.extensions.layoutHorizontal
import com.alvarengadev.alvaflix.utils.FormatDate
import com.alvarengadev.alvaflix.view.details.adapter.similar.MovieSimilarAdapter
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModel()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        ib_details_back.setOnClickListener {
            findNavController().popBackStack()
        }

        val movie = args.movie

        tv_details_title_movie.text = movie.title
        tv_details_value_rating_movie.text = movie.rating
        tv_details_year_movie.text =
            getString(R.string.label_date_movies_details, FormatDate.getDate(movie.date))
        tv_details_description_movie.text = movie.description

        showIconMyList(movie)

        val imagePoster = movie.posterDetails ?: movie.poster

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${imagePoster}")
            .into(iv_details_poster_movie)

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
                tv_details_similar_movies.visibility = View.GONE
                rcy_details_similar_movies.visibility = View.GONE
            } else {
                tv_details_similar_movies.visibility = View.VISIBLE
                rcy_details_similar_movies.apply {
                    visibility = View.VISIBLE
                    adapter = movieSimilarAdapter
                    layoutManager = this.layoutHorizontal()
                }
            }
        })
    }

    private fun showIconMyList(movie: Movie) {
        viewModel.isMovieFavorite(movie)
        viewModel.isMovieFavoriteData.observe(viewLifecycleOwner, { isFavorite ->
            if (isFavorite) {
                btn_linear_details_my_list.setOnClickListener(deleteMovieFavorite(movie))
                iv_details_icon_my_list.setImageResource(R.drawable.ic_check)
            } else {
                btn_linear_details_my_list.setOnClickListener(addMovieFavorite(movie))
                iv_details_icon_my_list.setImageResource(R.drawable.ic_plus)
            }
        })
    }

    private fun addMovieFavorite(movie: Movie) = View.OnClickListener {
        viewModel.insertMovieFavorite(movie)
        iv_details_icon_my_list.setImageResource(R.drawable.ic_check)
        requireContext().createToast("Add in My List")
    }

    private fun deleteMovieFavorite(movie: Movie) = View.OnClickListener {
        viewModel.deleteMovieFavorite(movie)
        iv_details_icon_my_list.setImageResource(R.drawable.ic_plus)
        requireContext().createToast("Delete in My List")
    }
}