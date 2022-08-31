package com.example.cbubank.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cbubank.R
import com.example.cbubank.data.models.ValyutData
import com.example.cbubank.databinding.ItemViewBinding

class MainAdapter : ListAdapter<ValyutData, MainAdapter.Holder>(CbuComparator) {
    private var itemClickListener: ((ValyutData) -> Unit)? = null

    inner class Holder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {



        init {
            binding.root.setOnClickListener {
                itemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind() {
            binding.apply {
                name.text = getItem(absoluteAdapterPosition).name
                shortName.text = getItem(absoluteAdapterPosition).shortName
                tvRate.text = getItem(absoluteAdapterPosition).rate
                tvDate.text = getItem(absoluteAdapterPosition).date
                if (getItem(absoluteAdapterPosition).diff.toDouble() > 0) {
                    imgCursProgress.setImageResource(R.drawable.profit)
                } else {
                    imgCursProgress.setImageResource(R.drawable.arrow)
                }
            }
        }
    }

    object CbuComparator : DiffUtil.ItemCallback<ValyutData>() {
        override fun areItemsTheSame(oldItem: ValyutData, newItem: ValyutData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ValyutData, newItem: ValyutData): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.shortName == newItem.shortName &&
                    oldItem.date == newItem.date && oldItem.diff == newItem.diff && oldItem.rate == newItem.rate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind()


    fun setItemClickListener(block: (ValyutData) -> Unit) {
        itemClickListener = block
    }


}