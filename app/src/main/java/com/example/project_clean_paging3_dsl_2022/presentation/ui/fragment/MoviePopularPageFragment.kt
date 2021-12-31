package com.example.project_clean_paging3_dsl_2022.presentation.ui.fragment

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseFragment
import com.example.components.ApiResponse
import com.example.components.ErrorMessage
import com.example.displayedChild
import com.example.domain.model.ResultMapper
import com.example.project_clean_paging3_dsl_2022.databinding.MoviePopularPageFragmentBinding
import com.example.project_clean_paging3_dsl_2022.presentation.ui.adapter.MoviePopularAdapter
import com.example.project_clean_paging3_dsl_2022.presentation.ui.adapter.OnClickListener
import com.example.project_clean_paging3_dsl_2022.presentation.ui.viewmodel.MoviePopularPageViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val MOVIE_POPULAR = "MOVIE_POPULAR"
@ExperimentalCoroutinesApi
class MoviePopularPageFragment : BaseFragment<MoviePopularPageViewModel, MoviePopularPageFragmentBinding>() {

    lateinit var movieAdapter: MoviePopularAdapter
    lateinit var fragmentStatus: String

    override fun getViewModel(): MoviePopularPageViewModel {
        val moviePopularVM : MoviePopularPageViewModel by viewModel()
        return moviePopularVM
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = MoviePopularPageFragmentBinding.inflate(inflater, container, false)

    private fun initRyclerView() {
        binding!!.rvMoviePopular.apply {
            layoutManager = LinearLayoutManager(requireContext())
            movieAdapter = MoviePopularAdapter(OnClickListener{ resultMapper ->
                resultMapper?.let {
                    //findNavController().navigate(MoviePopularPageFragmentDirections.actionMoviePopularPageFragmentToDetailFragment(it))
                }
            })
            adapter = movieAdapter
        }
    }


    private fun initViewModel(){

        vModel.getPopularMoviesPage()
        vModel.popularMovies.observe(this,{ response->
            when(response){
                is ApiResponse.Loading->{
                    showLoading()
                }
                is ApiResponse.Success->{
                    populateMovie(response.data)
                }
                is ApiResponse.Failure->{
                    showError(response.errorMessage)
                }
            }
        })

    }
    private fun showError(errorMessage: ErrorMessage) {

        Handler().postDelayed({
            displayedChild(2, binding!!.vfListRxResult)
            binding?.tvMovieError?.text = errorMessage.message
        }, 1000)
    }

    private fun populateMovie(data: PagingData<ResultMapper>) {
        Handler().postDelayed({
            displayedChild(1, binding!!.vfListRxResult)
            movieAdapter.submitData(lifecycle, data)
        }, 1000)

    }

    private fun showLoading() {
        displayedChild(0, binding!!.vfListRxResult)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vModel.destroy()
        binding = null
    }

    override fun onStart() {
        super.onStart()
        vModel.start()
        initViewModel()
        initRyclerView()
    }
}