package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultMapper(
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val original_language: String,
    val vote_average: String,
    val poster_path: String,
    val backdrop_path: String
): Parcelable