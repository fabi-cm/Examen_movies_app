package com.example.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//object RetrofitBuilder {
//    private const val BASE_URL = "https://api.github.com"
//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .addConverterFactory(MoshiConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//    }
//    val apiService: IApiService = getRetrofit().create(IApiService::class.java)
//}
object RetrofitBuilder {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val apiService: MovieApiService = getRetrofit().create(MovieApiService::class.java)
}