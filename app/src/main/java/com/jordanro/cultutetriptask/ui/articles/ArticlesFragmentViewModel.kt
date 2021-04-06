package com.jordanro.cultutetriptask.ui.articles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.jordanro.cultutetriptask.repositories.ArticlesRepository

class ArticlesFragmentViewModel  @ViewModelInject constructor(
    private val repository: ArticlesRepository
) : ViewModel() {

    val articles = repository.loadArticles()
}