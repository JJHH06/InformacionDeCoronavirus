package com.example.informaciondecoronavirus.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.informaciondecoronavirus.R
import com.example.informaciondecoronavirus.databinding.ActivityMainBinding


//Jose Hurtarte 19707
class MainActivity : AppCompatActivity() {

    //Variable binding del databinding
    private lateinit var binding: ActivityMainBinding

    //esta variable sirve para comprobar si ya se ha hecho un submit de los datos del usuario
    var is_submitted : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        try{
            //Aqui intenta hacer el toast si no es nulo o si no esta vacio

            var commentario = intent.extras?.getString("comentario")//tuve que colocar esto porque sino daba un toast vacio siempre
            if (!commentario.isNullOrEmpty()){
                Toast.makeText(this,commentario,Toast.LENGTH_LONG).show()
            }

        }catch (e:Exception){

        }

        binding.infoMainButton.setOnClickListener{
            //comprobacion si esta vacio o no
            if(!(binding.userNameEdit.text.toString().isNullOrEmpty()) && !(binding.userAgeEdit.text.toString().isNullOrEmpty())) {

                //verifica si el intervalo establecido esta bien
                if (comprobarIntervalo()){

                    fijarDatosUsuario() //llama a la funcion encargada de fijar datos
                }
                else{
                    Toast.makeText(this, "Ingrese una edad valida, entre 0 y 130", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Llene los campos vacios", Toast.LENGTH_LONG).show()
            }
        }
        //va a la pestania modificada para virus
        binding.buttonGoVirus.setOnClickListener {
            var intent = Intent(this, InformationVirus::class.java)
            intent.putExtra("option",1)

            startActivity(intent)
        }
        //va a la pestania modificada para sintomas
        binding.buttonGoSintomas.setOnClickListener {
            var intent = Intent(this, InformationVirus::class.java)
            intent.putExtra("option",2)
            startActivity(intent)
        }
        //va a la pestania modificada para indicaciones
        binding.buttonGoIndicaciones.setOnClickListener {
            var intent = Intent(this, InformationVirus::class.java)
            intent.putExtra("option",3)
            startActivity(intent)
        }


    }


    /**
     * Comprueba devilviendo true si la entrada esta entre 0 y 150
     *
     */
    private fun comprobarIntervalo(): Boolean{
        var resultado : Boolean = false

        //Se verifica mas que la edad no sea exageradamente alta
        if ( (binding.userAgeEdit.text.toString().toFloat() <= 150) &&  (binding.userAgeEdit.text.toString().toFloat() >= 0)){
            resultado = true
        }
        return resultado
    }

    /**
     * coloca o quita los datos del usuario para volver a tirar el Toast
     */
    private fun fijarDatosUsuario(){
        binding.apply {
            if (!is_submitted) {
                textViewUserAge.text = userAgeEdit.text
                textViewUserName.text = userNameEdit.text
                invalidateAll()  //se extrae los datos

                userAgeEdit.visibility = View.GONE //se ocultan los datos
                userNameEdit.visibility = View.GONE

                textViewUserAge.visibility = View.VISIBLE //se vuelve visible los textos fijos
                textViewUserName.visibility = View.VISIBLE

                // info de https://www.worldometers.info/coronavirus/coronavirus-age-sex-demographics/
                // se hacen los ifs dependiendo del riesgo para tirar el Toast

                if(textViewUserAge.text.toString().toFloat() <= 17){
                    Toast.makeText( this@MainActivity,textViewUserName.text.toString()+" por la edad esta en bajo riesgo si posee COVID-19", Toast.LENGTH_LONG).show()
                }
                else if(textViewUserAge.text.toString().toFloat() <= 44.00){
                    Toast.makeText( this@MainActivity,textViewUserName.text.toString()+" por la edad esta en riesgo moderado si posee COVID-19", Toast.LENGTH_LONG).show()
                }

                else if(textViewUserAge.text.toString().toFloat() <= 64.00){
                    Toast.makeText( this@MainActivity,textViewUserName.text.toString()+" por la edad esta en riesgo ALTO si posee COVID-19", Toast.LENGTH_LONG).show()
                }
                else if(textViewUserAge.text.toString().toFloat() <= 74.00){
                    Toast.makeText( this@MainActivity,textViewUserName.text.toString()+" por la edad esta en riesgo MUY ALTO si posee COVID-19", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText( this@MainActivity,textViewUserName.text.toString()+" por la edad esta en riesgo EXTREMADAMENTE ALTO si posee COVID-19", Toast.LENGTH_LONG).show()
                }
                is_submitted = !is_submitted //cambia el verificador
            }
            else {
                //Se vacian los edit text
                userAgeEdit.text = null
                userNameEdit.text = null
                invalidateAll()

                //Se ocultan los view text para volverlos a llenar despues
                textViewUserAge.visibility = View.GONE
                textViewUserName.visibility = View.GONE

                //se vuelven visibles los edit text vacios
                userAgeEdit.visibility = View.VISIBLE
                userNameEdit.visibility = View.VISIBLE

                is_submitted = !is_submitted  //cambia el verificador
            }




        }
    }
}
