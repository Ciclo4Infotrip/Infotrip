package com.karendamore.metabile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class ListJardinActivity : AppCompatActivity() {

    private lateinit var listJardin: ArrayList<Jardin>
    private lateinit var jardinAdapter: JardinAdapter
    private lateinit var jardinRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_jardin)

        jardinRecyclerView = findViewById(R.id.jardin_recycler_view)

        listJardin = createMockJardin()


        jardinAdapter = JardinAdapter(listJardin)

        jardinRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        jardinRecyclerView.adapter = jardinAdapter
    }

    private fun createMockJardin(): ArrayList<Jardin>{
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
                puntuacion = "Puntuación: 4.8 / 5"
            ),
            Jardin(
                nombre = "Mirador Cristo Rey",
                descripcion = "Mirador y restaurante donde podrás divisar Jardín desde lo alto de la montaña.",
                puntuacion = "Puntuación: 4.5 / 5"
            ),
            Jardin(
                nombre = "Teleférico la Garrucha",
                descripcion = "Medio de transporte de pasajeros y de mercancías, comunica el pueblo con la vereda Serranías.",
                puntuacion = "Puntuación: 4.4 / 5"
            ),
            Jardin(
                nombre = "Cueva del Esplendor",
                descripcion = "Cueva donde la fuerza del agua abrió un agujero en una roca gigantesca de la montaña.",
                puntuacion = "Puntuación: 4.8 / 5"
            ),
            Jardin(
                nombre = "Las Trucheras",
                descripcion = "En ellas puedes disfrutar de las diversas preparaciones culinarias de la Trucha.",
                puntuacion = "Puntuación: 4.2 / 5"
            ),
            Jardin(
                nombre = "Café Macanas Jardín",
                descripcion = "El mejor lugar en Jardín para tomarse un buen café y disfrutar de la más deliciosa pastelería.",
                puntuacion = "Puntuación: 4.7 / 5"
            ),
            Jardin(
                nombre = "Dulces Jardín",
                descripcion = "Producción, preparación y comercialización de dulces típicos.",
                puntuacion = "Puntuación: 4.7 / 5"
            ),
        )
    }
}