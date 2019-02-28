package com.elintminds.osdb.data.network


import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean
import com.elintminds.osdb.ui.login.beans.UserBean
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import java.util.ArrayList


@JvmSuppressWildcards
interface ApiHelper {

    @FormUrlEncoded
    @POST("login")
    fun getUserLogin(@Field("email") email : String, @Field("password") password:String): Observable<UserBean>

    @GET("sports/list")
    fun fetchAllSportsList(): Observable<ArrayList<SportsAdapterListBean>>

}
