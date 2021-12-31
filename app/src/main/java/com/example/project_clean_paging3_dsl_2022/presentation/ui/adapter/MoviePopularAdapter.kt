package com.example.project_clean_paging3_dsl_2022.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ResultMapper
import com.example.project_clean_paging3_dsl_2022.R

class MoviePopularAdapter(private val onClick: OnClickListener) : PagingDataAdapter<ResultMapper, MoviePopularAdapter.ResultViewHolder>(DiffUtilCallBack()){

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(getItem(position), onClick.clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
       val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_popular, parent, false)
        return ResultViewHolder(inflate)
    }

    class ResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var title : TextView = itemView.findViewById(R.id.tvTitle)
        var subtitle : TextView = itemView.findViewById(R.id.tvSubtitle)
        fun bind(item: ResultMapper?, onClick: (item: ResultMapper?) -> Unit) {
            title.text = item?.title
            subtitle.text = item?.overview
            itemView.setOnClickListener { onClick(item) }
        }



    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<ResultMapper>(){
        override fun areItemsTheSame(oldItem: ResultMapper, newItem: ResultMapper): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultMapper, newItem: ResultMapper): Boolean {
            return oldItem == newItem
        }

    }
}

data class OnClickListener(val clickListener: (item: ResultMapper?) -> Unit)


