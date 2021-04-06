package com.jordanro.cultutetriptask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordanro.cultutetriptask.application.NavigationComponent
import com.jordanro.cultutetriptask.ui.MainFragment
import com.jordanro.cultutetriptask.ui.articles.ArticlesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,NavigationComponent{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMain()
    }

    override fun showMain() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MainFragment()).commit()
    }

    override fun showArticles() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,ArticlesFragment()).addToBackStack(null).commit()
    }
}