package com.practical.model.response

data class NasaResponse(
    val copyright: String = "",
    val date: String = "",
    val explanation: String = "",
    val hdurl: String = "",
    val media_type: String = "",
    val service_version: String = "",
    var title: String = "",
    val url: String = ""
)