package ru.wildberries.travelwb.repository

import androidx.lifecycle.LiveData
import ru.wildberries.travelwb.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeBySearchToken(searchToken: String)
}