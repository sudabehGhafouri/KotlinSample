package com.mersana.kotlinsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SearchModel(
    @PrimaryKey val id: Long,
    val name: String,
    val full_name: String,
    val description: String?,
    val html_url: String,
    val stargazers_count: Int = 0,
    val forks_count: Int = 0,
    val language: String?)
