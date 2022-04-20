package xyz.zohre.picnic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zohre.mobiquityapp.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.multibindings.IntoMap
import xyz.zohre.ui.product.ProductViewModel

/**
 * Maybe it's better to use view model injector from jetpack but because it was in alpha stage I wrote something by
 * myself and we can change it later if we know the SDK is stable.
 *
 */
@Module
@InstallIn(FragmentComponent::class)
interface ViewModelBuilder {
    @Binds
    fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    fun bindRandomGifViewModel(viewModel: ProductViewModel): ViewModel

}