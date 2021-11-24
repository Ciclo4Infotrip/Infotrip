package com.karendamore.Infotrip


import com.google.gson.annotations.SerializedName

data class JardinItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)