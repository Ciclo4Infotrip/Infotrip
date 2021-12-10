package com.karendamore.jardin.list


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karendamore.jardin.R
import com.karendamore.jardin.model.JardinItem
import com.squareup.picasso.Picasso

class JardinAdapter(
    private val jardinList: ArrayList<JardinItem>,
    private val onItemClicked: (JardinItem) -> Unit,
) : RecyclerView.Adapter<JardinAdapter.JardinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JardinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_jardin_item, parent, false)
        return JardinViewHolder(view)

    }

    override fun onBindViewHolder(holder: JardinViewHolder, position: Int) {
        val jardin = jardinList [position]
        holder.itemView.setOnClickListener{onItemClicked(jardinList[position] )}
        holder.bind(jardin)


    }

    override fun getItemCount(): Int = jardinList.size

    fun appendItems(newItems: ArrayList<JardinItem>) {
        jardinList.clear()
        jardinList.addAll(newItems)
    }

    class JardinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(jardin: JardinItem){
            Log.d("nombre",jardin.nombre)
            nameTextView.text = jardin.nombre
            descripcionTextView.text = jardin.descripcion
            puntuacionTextView.text = jardin.puntuacion
            Picasso.get().load(jardin.urlPicture).into(pictureImageView)


        }

    }
}
