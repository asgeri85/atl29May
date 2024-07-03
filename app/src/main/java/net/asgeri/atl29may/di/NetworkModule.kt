package net.asgeri.atl29may.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.asgeri.atl29may.api.ProductService
import net.asgeri.atl29may.local.LocalDataBase
import net.asgeri.atl29may.local.ProductDAO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): LocalDataBase {
        return Room.databaseBuilder(context, LocalDataBase::class.java, "local_db").build()
    }

    @Singleton
    @Provides
    fun provideDataBase(wordDatabase: LocalDataBase): ProductDAO {
        return wordDatabase.createDAO()
    }


}