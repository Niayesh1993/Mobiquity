package xyz.zohre.ui.product

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import kotlinx.android.synthetic.main.row_item_product.view.*
import xyz.zohre.data.model.Product
import xyz.zohre.presentation_shared.adapter.BaseRecyclerAdapter
import xyz.zohre.presentation_shared.adapter.BaseViewHolder
import xyz.zohre.presentation_shared.bindImage
import xyz.zohre.ui.R
import com.bumptech.glide.request.target.Target

class ProductRecyclerAdapter: BaseRecyclerAdapter<Product,
        ProductRecyclerAdapter.ViewHolder,
        BaseViewHolder.OnItemClickListener<Product>>() {

    override fun viewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.row_item_product,
                parent,
                false
            ),
            this
        )
    }

    override fun onBindView(holder: ViewHolder?, position: Int) {
        holder?.bind(data[position])    }

    class ViewHolder(itemView: View,
                     adapter: ProductRecyclerAdapter,)
        : BaseViewHolder<Product>(itemView, adapter){
        override fun bind(t: Product) {

            itemView.product_name.text = t.name

            bindImage(
                imageUrl = t.url,
                imageView = itemView.product_img,
                listener = object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target:Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target:Target<Drawable>?,
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                }

            )
        }

    }
}