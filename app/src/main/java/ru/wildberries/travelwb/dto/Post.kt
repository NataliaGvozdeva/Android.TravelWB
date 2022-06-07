package ru.wildberries.travelwb.dto

data class Post (
    val startCity: String,
    val startCityCode: String,
    val endCity: String,
    val endCityCode: String,
    val startDate: String,
    val endDate: String,
    val price: Long,
    val searchToken: String,
    val likedByMe: Boolean,
    val likesSum: Long
)