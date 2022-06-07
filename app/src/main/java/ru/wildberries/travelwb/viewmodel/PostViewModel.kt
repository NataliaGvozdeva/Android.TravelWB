package ru.wildberries.travelwb.viewmodel

import androidx.lifecycle.ViewModel
import ru.wildberries.travelwb.repository.PostRepository
import ru.wildberries.travelwb.repository.PostRepositoryInMemoryImpl

class PostViewModel  : ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()

    fun likeBySearchToken(searchToken: String) = repository.likeBySearchToken(searchToken)
}