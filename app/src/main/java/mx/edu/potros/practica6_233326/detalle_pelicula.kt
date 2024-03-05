package mx.edu.potros.practica6_233326

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        val tv_movie_image: ImageView = findViewById(R.id.tv_movie_image)
        val tv_movie_name: TextView = findViewById(R.id.tv_movie_name)
        val tv_movie_desc: TextView = findViewById(R.id.tv_movie_desc)
        val seatsLeft: TextView = findViewById(R.id.seatLeft)
        val buyTickets: TextView = findViewById(R.id.buyTickets)
        var ns = 0
        var id = -1
        var title = ""

        if (bundle != null) {
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            tv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_name.text = bundle.getString("titulo")
            tv_movie_desc.text = bundle.getString("sinopsis")
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")
        }

        if (ns == 0) {
            buyTickets.isEnabled = false
        } else {
            buyTickets.setOnClickListener {
                buyTickets.isEnabled = true
                val intent: Intent = Intent(this,
                    SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("name", title)
                this.startActivity(intent)
            }
        }
    }
}