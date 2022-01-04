package com.example.project_clean_paging3_dsl_2022.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.base.BaseFragment
import com.example.domain.model.ResultMapper
import com.example.project_clean_paging3_dsl_2022.R
import com.example.project_clean_paging3_dsl_2022.databinding.FragmentDetailBinding
import com.example.project_clean_paging3_dsl_2022.presentation.ui.viewmodel.DefaultViewModel
import com.example.utilities.image.ImageUtils
import org.koin.androidx.viewmodel.ext.android.viewModel
private const val MOVIE_POPULAR = "MOVIE_POPULAR"


class DetailFragment : BaseFragment<DefaultViewModel, FragmentDetailBinding>() {
    private var result: ResultMapper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getParcelable(MOVIE_POPULAR)
        }
    }


    override fun getViewModel(): DefaultViewModel {
        val baseViewModel: DefaultViewModel by viewModel()
        return baseViewModel
    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { view ->
            view.tvIdValue.text = result?.id.toString()
            view.tvTitleValue.text = result?.title
            view.tvDateValue.text = result?.release_date
            view.tValor.text = result?.vote_average
            view.tvOverviewValue.text = result?.overview

            view.tb.btnLeft.setOnClickListener {
                requireActivity().onBackPressed()
            }

            ImageUtils.loadImage(view.tvImage, result?.backdrop_path, R.drawable.ic_placeholder)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}