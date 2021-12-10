package com.karendamore.jardin.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.karendamore.jardin.model.Jardin
import com.karendamore.jardin.model.JardinItem
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var jardinLoad : MutableLiveData<ArrayList<JardinItem>> = MutableLiveData()
    val onJardinLoaded: LiveData<ArrayList<JardinItem>> = jardinLoad

    fun loadMockJardinFromJson(jardinString: InputStream?) {
        @Suppress("NAME_SHADOWING")
        val jardinString = jardinString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        jardinLoad.value = gson.fromJson(jardinString, Jardin::class.java)
    }

}