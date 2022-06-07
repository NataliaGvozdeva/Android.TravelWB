package ru.wildberries.travelwb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.wildberries.travelwb.R
import ru.wildberries.travelwb.databinding.CardPostBinding
import ru.wildberries.travelwb.dto.Post
import java.math.RoundingMode
import java.text.DecimalFormat

interface OnInteractionListener {
    fun onLike(post: Post) {}
}

class PostsAdapter(private val OnInteractionListener: OnInteractionListener
)
    : ListAdapter<Post, PostViewHolder>(PostDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, OnInteractionListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

}

class PostDiffCallback : DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post,newItem: Post) : Boolean {
        return oldItem.searchToken == newItem.searchToken
    }

    override fun areContentsTheSame(oldItem: Post,newItem: Post) : Boolean {
        return oldItem == newItem
    }
}

class PostViewHolder(
    private val binding: CardPostBinding,
    private val OnInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            startCity.text = post.startCity
            endCity.text = post.endCity
            dateToDepartureData.text = post.startDate
            dateToArriveData.text = post.endDate
            price.text = post.price.toString()

            like.setOnClickListener{
                OnInteractionListener.onLike(post)
            }

            like.isChecked = post.likedByMe

        }
    }



}