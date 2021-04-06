package com.jordanro.cultutetriptask.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordanro.cultutetriptask.R
import com.jordanro.cultutetriptask.data.entities.ArticleList
import com.jordanro.cultutetriptask.data.utils.Resource
import com.jordanro.cultutetriptask.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_articles.*

class ArticlesFragment: BaseFragment() {

    private val viewModel: ArticlesFragmentViewModel by viewModels()
    private val adapter = ArticlesAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleList.layoutManager = LinearLayoutManager(context)
        articleList.adapter = adapter
        viewModel.articles.observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.LOADING -> handleLoading()
                Resource.Status.SUCCESS -> handleLoaded(it.data)
                else -> handleError(it.message)
            }
        })
    }

    private fun handleError(message: String?) {
        progressBar.visibility = View.GONE
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    private fun handleLoaded(articleList: ArticleList?) {
        adapter.setItems(articleList!!.data)
        progressBar.visibility = View.GONE
    }

    private fun handleLoading() {
        progressBar.visibility = View.VISIBLE
    }

}