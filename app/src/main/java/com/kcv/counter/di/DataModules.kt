package com.kcv.counter.di

import android.content.Context
import androidx.room.Room
import com.kcv.counter.data.local.ItemDao
import com.kcv.counter.data.local.CounterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CounterDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CounterDatabase::class.java,
            "Items.db"
        ).build()
    }

    @Provides
    fun provideItemDao(database: CounterDatabase) : ItemDao = database.itemDao()
}
