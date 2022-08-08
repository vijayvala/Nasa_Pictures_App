package com.obvious.vijay.nasapicturesapp.ui.listener

interface OnItemClick {
    fun <T>onClick(data: T,position:Int)
}