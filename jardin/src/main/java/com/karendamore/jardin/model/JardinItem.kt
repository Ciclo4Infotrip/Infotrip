package com.karendamore.jardin.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class JardinItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("informacion")
    val informacion: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double

) : Serializable