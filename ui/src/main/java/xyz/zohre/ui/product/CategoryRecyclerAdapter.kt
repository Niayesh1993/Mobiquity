package xyz.zohre.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import kotlinx.android.synthetic.main.row_item_category.view.*
import xyz.zohre.data.model.Category
import xyz.zohre.data.model.Product
import xyz.zohre.presentation_shared.adapter.BaseRecyclerAdapter
import xyz.zohre.presentation_shared.adapter.BaseViewHolder
import xyz.zohre.ui.R

class CategoryRecyclerAdapter: BaseRecyclerAdapter<
        Category,
        CategoryRecyclerAdapter.ViewHolder,
        BaseViewHolder.OnItemClickListener<Category>>() {
    lateinit var itemClickListener: BaseViewHolder.OnItemClickListener<Product>

    override fun viewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.row_item_category,
                parent,
                false
            ),
            this
        )
    }

    override fun onBindView(holder: ViewHolder?, position: Int) {
        holder?.bind(data[position])    }

    inner class ViewHolder(
        itemView: View,
        adapter: CategoryRecyclerAdapter,
    ): BaseViewHolder<Category>(itemView, adapter){

        private  var itemAdapter= ProductRecyclerAdapter()
        private var isExpanded = true

        override fun bind(t: Category) {

            itemView.title.text = t.name
            itemView.recycler_products.adapter = itemAdapter
            itemAdapter.insertItems(t.products)
            itemAdapter.listener = itemClickListener

            setExpanded(isExpanded)

            itemView.expanded.setOnClickListener {
                isExpanded = if (isExpanded) {
                    setExpanded(false)
                    false
                } else {
                    setExpanded(true)
                    true
                }
            }
        }



        private fun setExpanded(expanded: Boolean) {
            if (expanded) {
                itemView.recycler_products.visibility = View.VISIBLE
                setDrawableLeft(itemView.expanded, R.drawable.ic_arrow_down_gray)
            } else {
                setDrawableLeft(itemView.expanded, R.drawable.ic_arrow_left_gray)
                itemView.recycler_products.visibility = View.GONE
            }
        }

        private fun setDrawableLeft(textView: TextView, @DrawableRes drawableRes: Int) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0)
        }
    }


}