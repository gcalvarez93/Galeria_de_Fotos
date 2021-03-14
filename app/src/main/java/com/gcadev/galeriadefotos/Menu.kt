package com.gcadev.galeriadefotos

import java.util.*

class Menu {
    //Agregamos un método Get
    //Creamos lasvariables idImagen y titulo
    val idImagen: Int
    val titulo: String

    //Las inicializamos
    constructor() {
        idImagen = 0
        titulo = ""
    }

    //Creamos un constructor
    private constructor(idImagen: Int, titulo: String) {
        this.idImagen = idImagen
        this.titulo = titulo
    }

    //Creamos un método tipo ArrayList con una variable tipo menu y otra variable tipo ArrayList<Menu>
    fun listaMenu(): ArrayList<Menu> {
        var menu: Menu
        val lista = ArrayList<Menu>()

        //Creamos 2 Arrays,uno tipo Integer,en el que guardaremos el id de las imágenes, y otro tipo String donde guardaremos los titulos de las imagenes
        val IdImagenes = arrayOf(R.drawable.debian, R.drawable.fedora, R.drawable.kalilinux, R.drawable.linuxmint, R.drawable.ubuntu)
        val titulos = arrayOf("Debian", "Fedora", "Kali Linux", "Linux Mint", "Ubuntu")

        //Recorremos los Arrays con un for
        for (i in IdImagenes.indices) {
            menu = Menu(IdImagenes[i], titulos[i])

            //Añadimos el menú a la lista
            lista.add(menu)
        }

        //Retornamos la lista
        return lista
    }
}