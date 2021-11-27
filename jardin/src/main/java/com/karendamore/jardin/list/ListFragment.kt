package com.karendamore.jardin.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.karendamore.jardin.databinding.FragmentListBinding
import com.karendamore.jardin.model.Jardin
import com.karendamore.jardin.model.JardinItem

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var JardinAdapter: JardinAdapter
    private lateinit var listJardin: ArrayList<JardinItem>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listJardin = loadMockJardinFromJson()
        JardinAdapter = JardinAdapter(listJardin, onItemClicked = { onJardinClicked() })
    }

    private fun onJardinClicked() {
        
    }

    /*private fun JardinAdapter(jardinList: ArrayList<JardinItem>): JardinAdapter {

    }*/

    private fun loadMockJardinFromJson(): ArrayList<JardinItem> {
        val jardinString: String = context?.assets?.open("jardin.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val jardinList = gson.fromJson(jardinString, Jardin::class.java)
        return jardinList
    }
}