package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesPopularMapper(
    val page: Int,
    val results: List<ResultMapper>,
    val total_pages: Int,
): Parcelable