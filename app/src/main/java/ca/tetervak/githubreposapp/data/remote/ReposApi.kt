package ca.tetervak.githubreposapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface ReposApi {
    @GET("repositories?q=mobile&sort=stars&per_page=20")
    suspend fun getRepos(@Query("page") page: Int): ReposResponse
}
