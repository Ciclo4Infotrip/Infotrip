package com.karendamore.jardin.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.karendamore.jardin.data.JardinRepository
import com.karendamore.jardin.model.Jardin
import com.karendamore.jardin.model.JardinItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var jardinLoad : MutableLiveData<ArrayList<JardinItem>> = MutableLiveData()
    val onJardinLoaded: LiveData<ArrayList<JardinItem>> = jardinLoad

    private val repository = JardinRepository()


    fun getJardinFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            jardinLoad.postValue(repository.getJardin())
        }
    }

    fun loadMockJardinFromJson(jardinString: InputStream?) {
        val jardinString = jardinString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        jardinLoad.value = gson.fromJson(jardinString, Jardin::class.java)
    }

}