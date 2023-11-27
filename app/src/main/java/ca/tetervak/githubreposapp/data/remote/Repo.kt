package ca.tetervak.githubreposapp.data.remote

import com.google.gson.annotations.SerializedName


data class Repo(
    @SerializedName("id")
    val id: String,
    @SerializedName("full_name")
    val name: String,
    @SerializedName("description")
    val description: String,
)