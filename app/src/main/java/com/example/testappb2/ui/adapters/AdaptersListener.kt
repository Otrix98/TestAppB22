package com.example.testappb2.ui.adapters

import com.example.testappb2.data.models.CategoryItem
import com.example.testappb2.data.models.ListItem


interface AdaptersListener {
    fun onClickCategory(item: CategoryItem)
    fun onClickItem(item: ListItem)
}