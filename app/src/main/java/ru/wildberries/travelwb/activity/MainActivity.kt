package ru.wildberries.travelwb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.wildberries.travelwb.viewmodel.PostViewModel
import ru.wildberries.travelwb.R
import ru.wildberries.travelwb.databinding.ActivityMainBinding
import androidx.activity.viewModels
import ru.wildberries.travelwb.adapter.OnInteractionListener
import ru.wildberries.travelwb.dto.Post
import ru.wildberries.travelwb.adapter.PostsAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        val adapter = PostsAdapter(object : OnInteractionListener {
            override fun onLike(post: Post) {
                viewModel.likeBySearchToken(post.searchToken)
            }

        })

        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }

    }
}