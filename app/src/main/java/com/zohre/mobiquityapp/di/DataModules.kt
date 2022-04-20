package com.zohre.mobiquityapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.zohre.data.discovery.ProductRepository
import xyz.zohre.data.discovery.ProductRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
class DataModules {

    @Provides
    fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository {
        return productRepositoryImpl
    }
}