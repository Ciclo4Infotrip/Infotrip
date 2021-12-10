package com.karendamore.jardin.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.karendamore.jardin.databinding.FragmentListBinding
import com.karendamore.jardin.main.MainActivity
import com.karendamore.jardin.model.JardinItem

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var jardinAdapter: JardinAdapter
    private var listJardin: ArrayList<JardinItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockJardinFromJson(context?.assets?.open("jardin.json"))

        listViewModel.onJardinLoaded.observe(viewLifecycleOwner, { result ->
            onJardinLoadedSubscribe(result)
        })

        jardinAdapter = JardinAdapter(listJardin, onItemClicked = { onJardinClicked(it) } )

        listBinding.jardinRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = jardinAdapter
            setHasFixedSize(false)
        }
    }


    private fun onJardinLoadedSubscribe(result: ArrayList<JardinItem>?) {
        result?.let { listJardin ->
            jardinAdapter.appendItems(listJardin)

        }
    }


    private fun onJardinClicked(jardin: JardinItem){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(jardin = jardin))
    }

}

