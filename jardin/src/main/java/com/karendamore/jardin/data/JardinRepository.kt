package com.karendamore.jardin.data

class JardinRepository {

    suspend fun getJardin() = ApiFactory.retrofit.getJardin()

}