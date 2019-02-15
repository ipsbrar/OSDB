package com.elintminds.osdb.data.network

import android.content.Context
import android.util.Log

import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass
import com.elintminds.osdb.data.network.WebserviceUrls
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
    private var placesRetrofitInstance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()
    var instance: ApiClient? = null


    fun getClient(context: Context): Retrofit
    {
        val httpClient = OkHttpClient.Builder()

        if (retrofit == null) {
            httpClient.connectTimeout(1000, TimeUnit.MINUTES)
            httpClient.readTimeout(2, TimeUnit.MINUTES)
            httpClient.writeTimeout(2, TimeUnit.MINUTES)
            httpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val builder = chain.request().newBuilder()

                    Log.e("TOKEN",""+ AppPreferenceHelperClass(context).token);
                    if (AppPreferenceHelperClass(context).token != "") {
                        builder.addHeader("token", AppPreferenceHelperClass(context).token)
                    }
                    return chain.proceed(builder.build())
                }
            })

            retrofit = Retrofit.Builder()
                    .baseUrl(WebserviceUrls.BASE_URL)
                    .client(httpClient.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

        }

        return retrofit!!
    }


    private fun okClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build()
    }

    /*fun placeSearch(): Retrofit {
        if (placesRetrofitInstance == null) {
            placesRetrofitInstance = Retrofit.Builder()
                    .baseUrl(WebserviceUrls.GOOGEL_PLACES)
                    .client(okClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson)).build()

        }
        return placesRetrofitInstance!!
    }*/
}
