package mx.edu.potros.practica6_233326

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val tv_movie_image: ImageView = findViewById(R.id.tv_movie_image)
        val tv_movie_name: TextView = findViewById(R.id.tv_movie_name)
        val tv_movie_desc: TextView = findViewById(R.id.tv_movie_desc)

        val bundle = intent.extras
        if (bundle != null) {
            tv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_name.text = bundle.getString("titulo")
            tv_movie_desc.text = bundle.getString("sinopsis")
        }
    }
}