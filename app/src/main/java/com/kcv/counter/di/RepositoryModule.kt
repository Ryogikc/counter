package com.kcv.counter.di

import com.kcv.counter.data.local.ItemDao
import com.kcv.counter.data.repository.ItemRepositoryImpl
import com.kcv.counter.domain.contract.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
        @Provides
        fun provideItemRepository(itemDao: ItemDao): ItemRepository{
            return ItemRepositoryImpl(itemDao)
        }
}
