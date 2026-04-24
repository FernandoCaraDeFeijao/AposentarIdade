package com.example.aposentaridade

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aposentaridade.databinding.ActivityMainBinding
const val apoM = 65
const val apoF = 62
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val Item = listOf("Masculino", "Feminino")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Item)

        binding.spinnerSexo.adapter = adapter
        binding.calcular.setOnClickListener {
            val sexoSelecionado = binding.spinnerSexo.selectedItem.toString()
            val idade = binding.idade.text.toString().toLongOrNull()
            var texto: String
            if(sexoSelecionado == "Masculino"){
                if (idade != null){
                        var resultado = apoM - idade
                        texto = if (resultado <= 0){
                            "Você já deveria estar aposentado"
                        }else{
                            "Faltam $resultado para você se aposentar"
                        }
                }else{
                    texto = "Informe uma idade"
                }
            }else{
                if (idade != null){
                    var resultado = apoF - idade
                    texto = if (resultado <= 0){
                        "Você já deveria estar aposentado"
                    }else{
                        "Faltam $resultado para você se aposentar"
                    }
                }else{
                    texto = "Informe uma idade"
                }
            }
            binding.result.text = texto
        }
    }
}