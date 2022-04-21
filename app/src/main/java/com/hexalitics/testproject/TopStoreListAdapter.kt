package com.hexalitics.testproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hexalitics.testproject.databinding.TopStoresRvItemBinding


class TopStoreListAdapter(
    private var context: Context,
    private var data: List<String>
) :
    RecyclerView.Adapter<TopStoreListAdapter.SingleViewHolder>() {
    var onClick: OnItemClickListener? = null

    fun setOnItemClickLitener(mOnItemClickListener: OnItemClickListener) {
        this.onClick = mOnItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val binding: TopStoresRvItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.top_stores_rv_item, parent, false
        )
        return SingleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {


       /* Glide.with(context)
            .load(data.get(position).selectedImage)
            .into(holder.binding.ivImage)*/

        if (onClick != null) {
            holder.itemView.setOnClickListener {
                onClick!!.onItemClick(
                    holder.itemView,
                    holder.adapterPosition
                )
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    inner class SingleViewHolder(val binding: TopStoresRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}