package ca.tetervak.githubreposapp.data.remote

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("items") val repos: List<Repo>
)