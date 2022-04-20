package xyz.zohre.ui.product

import androidx.lifecycle.ViewModel
import xyz.zohre.data.discovery.ProductRepository
import javax.inject.Inject

class ProductViewModel@Inject constructor(private val productRepository: ProductRepository): ViewModel() {
}