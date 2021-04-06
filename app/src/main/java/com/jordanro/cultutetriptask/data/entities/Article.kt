package com.jordanro.cultutetriptask.data.entities

data class Article(val id: String,
                   val title: String,
                   val author: Author,
                   val imageUrl: String,
                   val category: String,
                   val likesCount: Int,
                   val isSaved: Boolean,
                   val isLiked: Boolean,
                   val metaData: MetaData
)