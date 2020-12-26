package com.galihmayangga.android.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.galihmayangga.android.R
import com.galihmayangga.android.data.model.News
import com.galihmayangga.android.databinding.ItemNewsBinding
import com.galihmayangga.android.ui.base.BaseAdapter
import com.galihmayangga.android.ui.news.NewsActivity
import com.bumptech.glide.Glide


class NewsAdapter(val context: Context) : BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
       val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.urlToImage).into(mBinding.itemurlToImage)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }

}