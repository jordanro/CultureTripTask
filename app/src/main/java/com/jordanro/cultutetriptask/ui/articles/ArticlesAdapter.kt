package com.jordanro.cultutetriptask.ui.articles

import android.media.browse.MediaBrowser
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jordanro.cultutetriptask.R
import com.jordanro.cultutetriptask.data.entities.Article
import com.jordanro.cultutetriptask.utils.TimeUtils
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class ArticlesAdapter(var data: List<Article>?) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_item,parent,false))

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = data!![position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    fun setItems(items :List<Article>?){
        data = items
        notifyDataSetChanged()
    }

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view){


        private val title: TextView = view.findViewById(R.id.title)
        private val category: TextView = view.findViewById(R.id.category)
        private val image : ImageView = view.findViewById(R.id.image)
        private val createdAt: TextView = view.findViewById(R.id.createdAt)
        private val isSaved: ImageView = view.findViewById(R.id.isSaved)
        private val isLiked: ImageView = view.findViewById(R.id.isLiked)
        private val likesCount: TextView = view.findViewById(R.id.numOfLikes)

        private val authorImage : ImageView = view.findViewById(R.id.authorImage)
        private val authorName: TextView = view.findViewById(R.id.authorName)

        fun onBind(item: Article) {
            title.text = Html.fromHtml(item.title)
            category.text = item.category
            authorName.text = item.author.authorName
            createdAt.text = TimeUtils.displayDate(item.metaData.creationTime)

            val isSavedResource = if(item.isSaved) R.drawable.saved_24 else R.drawable.save_24
            isSaved.setImageResource(isSavedResource)

            val isLikedResource = if(item.isSaved) R.drawable.liked_24 else R.drawable.like_24
            isLiked.setImageResource(isLikedResource)

            likesCount.text = item.likesCount.toString()

            Picasso.get()
                .load(item.imageUrl)
                .into(image)

            Picasso.get()
                .load(item.author.authorAvatar.imageUrl)
                .into(authorImage)
        }

    }
}