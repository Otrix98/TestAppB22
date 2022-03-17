package com.example.testappb2.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.scopedstorage.utils.ViewBindingFragment
import com.example.testappb2.R
import com.example.testappb2.databinding.DetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailFragment : ViewBindingFragment<DetailFragmentBinding>(DetailFragmentBinding::inflate) {

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInfo()
        binding.retryButton.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToNewsFragment()
            findNavController().navigate(action)
        }
    }

   private fun setInfo() {
       val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE)
       val date = dateFormat.parse(args.item.publishedAt)
       val formatter =  SimpleDateFormat("yyyy.MM.dd, HH:ss", Locale.FRANCE)
       val dateString = formatter.format(date as Date)

        with(binding) {
            barTextView.text = args.item.author.orEmpty()
            titleTextView.text = args.item.title
            contentTextView.text = args.item.description
            dateTextView.text = dateString
        }

       Glide.with(requireContext())
           .load(args.item.urlToImage)
           .error(R.drawable.no_image)
           .into(binding.imageView)
    }
}