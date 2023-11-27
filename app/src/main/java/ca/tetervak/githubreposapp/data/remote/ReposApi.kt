package ca.tetervak.githubreposapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface ReposApi {
    @GET("repositories?q=mobile&sort=stars")
    suspend fun getRepos(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): ReposResponse
}
