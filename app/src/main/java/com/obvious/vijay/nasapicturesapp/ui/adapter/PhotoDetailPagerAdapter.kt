package com.obvious.vijay.nasapicturesapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.fragment.app.FragmentStatePagerAdapter

import com.obvious.vijay.nasapicturesapp.model.NasaModel
import com.obvious.vijay.nasapicturesapp.ui.fragment.PhotoDetailPagerFragment

class PhotoDetailPagerAdapter(fragmentManager:FragmentManager,private val dataList: Array<NasaModel>) :
    FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Fragment {
        return PhotoDetailPagerFragment.newInstance(dataList[position])
    }
}