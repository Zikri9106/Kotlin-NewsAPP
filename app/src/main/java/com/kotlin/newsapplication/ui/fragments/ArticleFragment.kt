package com.kotlin.newsapplication.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.kotlin.newsapplication.R
import com.kotlin.newsapplication.databinding.FragmentArticleBinding
import com.kotlin.newsapplication.ui.NewsActivity
import com.kotlin.newsapplication.ui.viewmodel.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
        binding.fab.setOnClickListener{
            newsViewModel.addToFavorite(article)
            Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_SHORT).show()
        }
    }
}