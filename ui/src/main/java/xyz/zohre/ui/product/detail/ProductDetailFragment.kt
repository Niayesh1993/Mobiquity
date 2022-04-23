package xyz.zohre.ui.product.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product_detail.*
import kotlinx.android.synthetic.main.row_item_product.view.*
import xyz.zohre.data.model.Product
import xyz.zohre.data.model.SalePrice
import xyz.zohre.presentation_shared.BaseFragment
import xyz.zohre.presentation_shared.bindImage
import xyz.zohre.ui.R


@AndroidEntryPoint
class ProductDetailFragment : BaseFragment() {
    private lateinit var product: Product
    private val args: ProductDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = args.myArg
        initView()
    }

    private fun initView() {
        pr_name.text = product.name
        pr_amount.text = showPrice(product.salePrice)

        bindImage(
            imageUrl = product.url,
            imageView = pr_img,
            listener = object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean,
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean,
                ): Boolean {
                    return false
                }

            }

        )
    }

    private fun showPrice(salePrice: SalePrice): String {
        return salePrice.amount.toString() + " " + salePrice.currency
    }

}