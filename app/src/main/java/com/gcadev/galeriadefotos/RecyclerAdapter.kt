package com.gcadev.galeriadefotos

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gcadev.galeriadefotos.RecyclerAdapter.MyViewHolder
import com.bumptech.glide.Glide
import java.util.*

class RecyclerAdapter  //Creamos un constructor para el adaptador
internal constructor(//Creamos 2 variables,una de tipo ArrayList y otra de tipo OnClickRecycler
    private val listaMenu: ArrayList<Menu>, private val listener: OnclickRecycler) : RecyclerView.Adapter<MyViewHolder>() {
    //Creamos una variable tipo view y llamamos al XML llamado adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.adaptador, parent, false)
        return MyViewHolder(view)
    }

    //Obtenemos el elemento que se encuentra en la posición
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val menu = listaMenu[position]
        holder.bind(menu, listener)
    }

    //Creamos una variable getItemCount para que contenga los elementos de la lista
    override fun getItemCount(): Int {
        return listaMenu.size
    }

    //Creamos una interfaz y agregamos el método OnClickItemRecycler dentro de la interfaz
    interface OnclickRecycler {
        fun OnClickItemRecycler(menu: Menu?)
    }

    //Creamos una clase ViewHolder para el Recycler y dentro de esta una variable tipo ImageView y dentro del método MyViewHolder llamamos a ImageView
    class MyViewHolder @SuppressLint("WrongViewCast") constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView

        //Creamos una variable para que reciba una variable menu y una variable OnclickRecycler
        internal fun bind(menu: Menu, listener: OnclickRecycler) {

            //Utilizamos Glide para evitar que se cuelgue la app cuando nos desplacemos por el Recycler
            Glide.with(imageView.context).load(menu.idImagen).into(imageView)
            itemView.setOnClickListener { listener.OnClickItemRecycler(menu) }
        }

        init {
            imageView = itemView.findViewById(R.id.imagengaleria)
        }
    }
}