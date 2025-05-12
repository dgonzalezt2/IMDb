package com.example.katas.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
   // funcion de apiInterface para detalle
    fun ProvideApiInterfaceDetalle(retrofit: Retrofit):ApiInterfaceDetalle{
        return  retrofit.create(ApiInterfaceDetalle::class.java)
    }
    // funcion de apiInterface para buscar
    @Provides
    @Singleton
    fun ProvideApiInterfaceBuscar(retrofit: Retrofit): ApiInterfaceBuscar {
        return  retrofit.create(ApiInterfaceBuscar::class.java)
    }
    @Provides
    @Singleton
    fun provideIMageUrl(): String {
        return  ApiConstants.IMAGE_URL
    }

}