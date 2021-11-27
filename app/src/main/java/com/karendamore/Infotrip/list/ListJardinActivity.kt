package com.karendamore.Infotrip.list

import Infotrip.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.karendamore.Infotrip.detalle.DetalleActivity
import com.karendamore.Infotrip.model.Jardin
import com.karendamore.Infotrip.model.JardinItem


class ListJardinActivity : AppCompatActivity() {

    private lateinit var listJardin: ArrayList<JardinItem>
    private lateinit var jardinAdapter: JardinAdapter
    private lateinit var jardinRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_jardin)

        jardinRecyclerView = findViewById(R.id.jardin_recycler_view)

    //    listJardin = createMockJardin()
        listJardin = loadMockJardinFromJson()
        jardinAdapter = JardinAdapter(listJardin)

        /*jardinRecyclerView.layoutManager= LinearLayoutManager(context)
        jardinRecyclerView.adapter = jardinAdapter*/


        /*jardinRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        jardinRecyclerView.adapter = jardinAdapter*/

        jardinRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter = jardinAdapter
            setHasFixedSize(false)
        }

    }
    /*private fun onJardinClicked(jardin: JardinItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("jardin",jardin)
        startActivity(intent)
    }*/

    private fun loadMockJardinFromJson(): ArrayList<JardinItem> {
        val jardinString: String = applicationContext.assets.open("jardin.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val jardinList = gson.fromJson(jardinString, Jardin::class.java)
        return jardinList


    }

    /* private fun createMockJardin(): ArrayList<Jardin>{
        /*crear jardin uno a uno
        var lista: ArrayList<Jardin> = arrayListOf()
        var jardin = Jardin(
            nombre = "Basílica de la Inmaculada Concepción",
            descripcion = "Es una basílica católica colombiana, es un templo de estilo neogótico.",
            puntuacion = "Puntuación: 4.8 / 5"
        )
        lista.add(jardin)
        return lista*/

        return arrayListOf(
            Jardin(
                nombre = "Basílica de la Inmaculada Concepción",
                descripcion = "Es una basílica católica colombiana, es un templo de estilo neogótico.",
                puntuacion = "Puntuación: 4.8 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637642175/Jardin/IglesiaJardin_fdbmop.jpg"
            ),
            Jardin(
                nombre = "Mirador Cristo Rey",
                descripcion = "Mirador y restaurante donde podrás divisar Jardín desde lo alto de la montaña.",
                puntuacion = "Puntuación: 4.5 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637633565/Jardin/CristoRey_q7p2zz.jpg"
            ),
            Jardin(
                nombre = "Teleférico la Garrucha",
                descripcion = "Medio de transporte de pasajeros y de mercancías, comunica el pueblo con la vereda Serranías.",
                puntuacion = "Puntuación: 4.4 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637642187/Jardin/TelefericoGarrucha_b8dphl.jpg"
            ),
            Jardin(
                nombre = "Cueva del Esplendor",
                descripcion = "Cueva donde la fuerza del agua abrió un agujero en una roca gigantesca de la montaña.",
                puntuacion = "Puntuación: 4.8 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637633585/Jardin/CuevaEsplendor_kbzvzu.jpg"
            ),
            Jardin(
                nombre = "Las Trucheras",
                descripcion = "En ellas puedes disfrutar de las diversas preparaciones culinarias de la Trucha.",
                puntuacion = "Puntuación: 4.2 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637633825/Jardin/Trucheras_bh5oad.jpg"
            ),
            Jardin(
                nombre = "Café Macanas Jardín",
                descripcion = "El mejor lugar en Jardín para tomarse un buen café y disfrutar de la más deliciosa pastelería.",
                puntuacion = "Puntuación: 4.7 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637633617/Jardin/CafeMacanas_b4yrrp.jpg"
            ),
            Jardin(
                nombre = "Dulces Jardín",
                descripcion = "Producción, preparación y comercialización de dulces típicos.",
                puntuacion = "Puntuación: 4.7 / 5",
                urlPicture = "https://res.cloudinary.com/dofzqtr4i/image/upload/v1637633624/Jardin/DulcesJardin_ntiohb.jpg"
            ),
        )
    }*/
}