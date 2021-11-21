package com.karendamore.metabile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JardinAdapter(
    private val jardinList: ArrayList<Jardin>
) : RecyclerView.Adapter<JardinAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_jardin_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jardin = jardinList [position]
        holder.bind(jardin)


    }

    override fun getItemCount(): Int = jardinList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var pictureTextView: TextView = itemView.findViewById(R.id.picture_image_view)

        fun bind(jardin: Jardin){
            nameTextView.text = jardin.nombre
            descripcionTextView.text = jardin.descripcion
            puntuacionTextView.text = jardin.puntuacion
            //picture

        }

    }
}
