package net.asgeri.atl29may.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.asgeri.atl29may.databinding.ItemPagerBinding

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    private val imageList = arrayListOf<String>()

    inner class PagerViewHolder(val itemPagerBinding: ItemPagerBinding) :
        RecyclerView.ViewHolder(itemPagerBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemPagerBinding.image = imageList[position]
    }

    fun updateList(newList: List<String>) {
        imageList.clear()
        imageList.addAll(newList)
        notifyDataSetChanged()
    }
}