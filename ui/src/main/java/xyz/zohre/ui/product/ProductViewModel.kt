package xyz.zohre.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import xyz.zohre.data.discovery.ProductRepository
import xyz.zohre.data.model.Category
import xyz.zohre.domain.entities.ApiResult
import xyz.zohre.presentation_shared.Event
import xyz.zohre.presentation_shared.TextData
import xyz.zohre.presentation_shared.parseErrorStringRes
import javax.inject.Inject

class ProductViewModel@Inject constructor(private val productRepository: ProductRepository): ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    private val _showError = MutableLiveData<Event<TextData>>()
    val showError: LiveData<Event<TextData>> = _showError

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun loadCategories() {

        viewModelScope.launch {
            productRepository().collect {
                showResult(it)
            }

        }
    }

    private fun showResult(result: ApiResult<List<Category>>) {
        when (result) {
            is ApiResult.Success -> {
               _categories.value = result.data
            }
            is ApiResult.Loading -> {
                _loading.value = true

            }
            is ApiResult.Error -> {
                result.exception.let {
                    _showError.value = Event(it.parseErrorStringRes())
                }
            }
        }

    }
}