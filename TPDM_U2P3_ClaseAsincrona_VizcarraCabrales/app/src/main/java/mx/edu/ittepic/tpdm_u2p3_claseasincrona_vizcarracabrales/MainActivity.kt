package mx.edu.ittepic.tpdm_u2p3_claseasincrona_vizcarracabrales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var valorN : EditText ?= null
    var valorM : EditText ?= null
    var boton : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contexto = this

        valorN = findViewById(R.id.valorN)
        valorM = findViewById(R.id.valorM)
        boton = findViewById(R.id.boton)

        boton?.setOnClickListener {

            if(!valorN?.text!!.isEmpty() && !valorM?.text!!.isEmpty()){

                var n = valorN?.text.toString().toInt()
                var m = valorM?.text.toString().toInt()

                if(n<m){

                    Asincrona().execute(n,m)

                }else{
                    mensaje("Necesita ser N < M")
                }
            }else{
                mensaje("Necesita llenar los campos")
            }
        }
    }

    companion object{

        lateinit var contexto: MainActivity

        fun mensaje(texto:String){
            Toast.makeText(contexto,texto,Toast.LENGTH_LONG).show()
        }
    }
}
