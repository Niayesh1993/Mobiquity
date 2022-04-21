package xyz.zohre.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_item_category.view.*
import xyz.zohre.data.model.Category
import xyz.zohre.presentation_shared.adapter.BaseRecyclerAdapter
import xyz.zohre.presentation_shared.adapter.BaseViewHolder
import xyz.zohre.ui.R

class CategoryRecyclerAdapter: BaseRecyclerAdapter<
        Category,
        CategoryRecyclerAdapter.ViewHolder,
        BaseViewHolder.OnItemClickListener<Category>>() {

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

    class ViewHolder(itemView: View,
                     adapter: CategoryRecyclerAdapter,)
        : BaseViewHolder<Category>(itemView, adapter){

        private  var itemAdapter= ProductRecyclerAdapter()

        override fun bind(t: Category) {

            itemView.title.text = t.name
            itemView.recycler_products.adapter = itemAdapter
            itemAdapter.insertItems(t.products)

        }
    }

}