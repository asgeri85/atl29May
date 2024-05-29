package net.asgeri.atl29may.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.asgeri.atl29may.databinding.ItemProductBinding
import net.asgeri.atl29may.model.ProductResponse

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList = arrayListOf<ProductResponse>()


    inner class ProductViewHolder(val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]

        holder.itemProductBinding.product = item

        val imageAdapter = PagerAdapter()
        holder.itemProductBinding.viewPager2.adapter = imageAdapter
        holder.itemProductBinding.dotsIndicator.attachTo(holder.itemProductBinding.viewPager2)
        item.images?.let {
            imageAdapter.updateList(it)
        }

    }

    fun updateList(newList: List<ProductResponse>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}