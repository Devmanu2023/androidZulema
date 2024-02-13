package com.example.maps


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.maps.databinding.ActivityMainBinding
import com.example.maps.models.DBManager




class MainActivity : AppCompatActivity() {
    //DataBinding
    /* Obligatorio para que funcione en build.gradle.kts(Module :app)
        viewBinding {

            enable = true

        }

     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val sena = binding.Sena
        val morro = binding.Morro
        val parque= binding.Parque

        val des = binding.descripcion
        val img = binding.imageView
        val latitud = binding.latitud
        val longitud = binding.longitud
        val boton = binding.button


        img.layoutParams.width = 400


        des.text = "El SENA, es un establecimiento público del orden nacional, con personería jurídica, patrimonio propio e independiente, y autonomía administrativa; adscrito al Ministerio del Trabajo, de Colombia. SENA una entidad de formación profesional al alcance de todos."
        //Configuración de Glide
        val imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4osuOdXdusmE9tNn4OthpsmZEZfICDYgKUJp6qAfWYJM3A7QjeiLtxQAeCosqzQzWhUI&usqp=CAU"
        Glide.with(this)
            .load(imgUrl)
            .into(img)

        latitud.text = "2.482846578974007"
        longitud.text = "-76.56253853293643"

        Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show()



                sena.setOnClickListener(){
                    des.text = "CTPI Popayán, lugar al que me toca ir a estudiar"
                    //Configuración de Glide
                    val imgUrl = "https://diariodelcauca.com.co/wp-content/uploads/2023/02/sena-cauca.jpg"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    latitud.text = "2.482846578974007"
                    longitud.text = "-76.56253853293643"
                }
                morro.setOnClickListener(){
                    des.text = "El morro con el Belalcazar borracho"
                    //Configuración de Glide
                    val imgUrl = "https://www.eltiempo.com/files/article_main/uploads/2020/09/20/5f677c2577d03.jpeg"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    latitud.text = "2.4457300673893245"
                    longitud.text = "-76.60016887826262"
                }
                parque.setOnClickListener(){
                    des.text = "El parquecito bomnito"
                    //Configuración de Glide
                    val imgUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9d/Whitecity.jpg"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    latitud.text = "2.442081779401729"
                    longitud.text = "-76.60630609060665"
                }





        boton.setOnClickListener(){
            val lat = latitud.text.toString()
            val long = longitud.text.toString()

            val manager = DBManager(this)
            manager.insertData(lat, long)
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }


    }
}
