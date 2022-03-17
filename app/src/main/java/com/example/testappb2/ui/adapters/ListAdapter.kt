package com.example.testappb2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testappb2.data.models.ListItem
import com.example.testappb2.R
import com.example.testappb2.databinding.ListItemBinding
import java.text.SimpleDateFormat
import java.util.*


class ListAdapter() : PagingDataAdapter<ListItem, ListAdapter.MenuHolder>(ItemComparator) {
    private var listener: AdaptersListener? = null
    fun setOnClickListener(onClickListener: AdaptersListener) {
        this.listener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuHolder {
        val itemBinding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuHolder(
            itemBinding
        )
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    private object ItemComparator:  DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }
    }


   inner class MenuHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(value: ListItem) {
            val newsImageView = itemView.findViewById<ImageView>(R.id.itemImage)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE)
            val date = dateFormat.parse(value.publishedAt)
            val formatter =  SimpleDateFormat("yyyy.MM.dd, HH:ss", Locale.FRANCE)
            val dateString = formatter.format(date as Date)

            binding.titleTextView.text = value.title
            binding.dateTextView.text = dateString

            Glide.with(newsImageView)
                .load(value.urlToImage)
                .error(R.drawable.no_image)
                .into(newsImageView)

            initListener(value)
    }
       private fun initListener(item: ListItem){
           binding.root.setOnClickListener {
               listener?.onClickItem(item)
           }
       }
}
    }