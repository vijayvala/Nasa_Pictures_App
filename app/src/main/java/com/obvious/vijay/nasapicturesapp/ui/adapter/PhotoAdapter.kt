package com.obvious.vijay.nasapicturesapp.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.obvious.vijay.nasapicturesapp.R
import com.obvious.vijay.nasapicturesapp.model.NasaModel
import com.obvious.vijay.nasapicturesapp.ui.listener.OnItemClick

class PhotoAdapter(val context: Context,val onItemClick: OnItemClick) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = arrayOf<NasaModel>()

    internal fun setDataList(dataList: Array<NasaModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView


        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[holder.adapterPosition]

        holder.title.text = data.title
        val media = data.url
        if (media !== null) {
            Glide.with(context)
                .load(media)
                .into(holder.image)
        } else {
            holder.image.setImageResource(R.drawable.ic_launcher_background)
        }
        holder.itemView.setOnClickListener {
            onItemClick.onClick(dataList,position)
        }
       // holder.desc.text = data.desc

        //holder.image.setImageResource(data.image)
    }

    override fun getItemCount() = dataList.size
}