package mx.edu.ittepic.tpdm_u2p3_claseasincrona_vizcarracabrales

import android.app.Activity
import android.os.AsyncTask
import java.io.OutputStreamWriter
import kotlin.random.Random

class Asincrona : AsyncTask<Int, Void, List<Int>>() {
    override fun doInBackground(vararg p0: Int?): List<Int> {

        var n = p0.get(0)
        var m = p0.get(1)

        /*
        var numeros : ArrayList<Int> ?= null
        (1..2000).forEach {
            numeros?.add((Math.random()*m!! + n!!).toInt())
        }
        */

        var numeros = List(2000){ Random.nextInt(n!!,m!!)}

        return numeros
    }

    override fun onPostExecute(result: List<Int>?) {
        super.onPostExecute(result)

        var numeros = ""

        (0..result!!.size-1).forEach {
            var numero = result.get(it)
            var contador = 0
            (1..numero).forEach {i->
                if (numero % i == 0){
                    contador++
                }
            }
            if (contador == 2){
                numeros = numeros + numero + "\n"
            }
        }
        var archivo = OutputStreamWriter(MainActivity.contexto.openFileOutput("primos.txt", Activity.MODE_PRIVATE))
        archivo.write(numeros)
        archivo.flush()
        archivo.close()
        MainActivity.mensaje("Guardado !!!")
    }
}