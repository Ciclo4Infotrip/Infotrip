package com.karendamore.jardin.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.karendamore.jardin.databinding.FragmentDetailBinding
import com.karendamore.jardin.main.MainActivity


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jardin= args.jardin

        with(detailBinding){
            nameTextView.text = jardin.nombre
            informacionTextView.text = jardin.informacion
            puntuacionTextView.text = jardin.puntuacion
            com.squareup.picasso.Picasso.get().load(jardin.urlPicture).into(pictureImageView)


        }
    }

}