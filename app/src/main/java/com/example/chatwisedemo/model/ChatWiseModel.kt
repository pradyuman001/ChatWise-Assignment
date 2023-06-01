package com.example.chatwisedemo.model

import com.google.gson.annotations.SerializedName

data class ChatWiseModel(

    @field:SerializedName("ChatWiseModel")
    val chatWiseModel: List<ChatWiseModelItem?>? = null
)

data class ChatWiseModelItem(

    @field:SerializedName("albumId")
    val albumId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null
)
