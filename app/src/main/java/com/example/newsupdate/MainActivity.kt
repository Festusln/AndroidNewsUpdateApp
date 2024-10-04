package com.example.newsupdate

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.entity.Article
import com.example.newsupdate.data.AppConstants
import com.example.newsupdate.ui.adapter.NewsAdapter
import com.example.newsupdate.ui.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Inject viewmodel
    private val newsViewModel : NewsViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar : ProgressBar
    private lateinit var newsAdapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchandUpdateNews()
    }


    private fun fetchandUpdateNews() {
        progressBar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val response = newsViewModel.getNewsHeadline(AppConstants.COUNTRY)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    progressBar.visibility = View.INVISIBLE
                    val newsList: List<Article>? = response.body()?.articles
                    if (newsList.isNullOrEmpty()) {
                        Toast.makeText(
                            this@MainActivity,
                            "No news available, Check back later",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        newsAdapter = NewsAdapter(newsList)
                        recyclerView.adapter = newsAdapter
                    }

                } else {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}