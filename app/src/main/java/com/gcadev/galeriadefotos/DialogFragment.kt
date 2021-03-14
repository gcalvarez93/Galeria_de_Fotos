package com.gcadev.galeriadefotos

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gcadev.galeriadefotos.RecyclerAdapter.OnclickRecycler
import java.util.*

class DialogFragmentGaleria : DialogFragment() {
    //Creamos una variable tipo TextView y otra tipo ImageView
    var title: TextView? = null
    var image: ImageView? = null
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Creamos una variable tipo view y le añadimos la vista para utilizar los elementos del XML
        val view = inflater.inflate(R.layout.fragment_dialog_galeria, container, false)

        //Llamamos al titulo,a la imagen y al recycler desde el XML
        title = view.findViewById(R.id.titulo)
        image = view.findViewById(R.id.imagen)
        val recyclerViewgaleria: RecyclerView = view.findViewById(R.id.galeria)

        //Desaparece el Dialog Fragmental hacer clic en la imagen
        image!!.setOnClickListener(View.OnClickListener { Objects.requireNonNull(dialog)?.dismiss() })

        //Llamamos a la  variable RecyclerView y escribimos false para que por defecto nos aparezca la primera imagen añadida y no la ´ultima
        recyclerViewgaleria.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listaMenu = Menu().listaMenu()
        val adapter = RecyclerAdapter(listaMenu, object : OnclickRecycler {
            override fun OnClickItemRecycler(menu: Menu?) {
                Glide.with(Objects.requireNonNull(context)!!).load(menu!!.idImagen).into(image!!)
                with(title) { this!!.setText(menu.titulo) }
            }
        })
        recyclerViewgaleria.adapter = adapter
        return view
    }
}