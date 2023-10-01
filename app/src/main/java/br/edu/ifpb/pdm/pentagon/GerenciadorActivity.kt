package br.edu.ifpb.pdm.pentagon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.slider.Slider

class GerenciadorActivity : AppCompatActivity() {
    private lateinit var senha: Senha;

    private lateinit var titulo:TextView;
    private lateinit var descricao:EditText;

    private lateinit var slider: Slider;
    private lateinit var valorMinimoSlider:TextView;
    private lateinit var valorMaximoSlider:TextView;
    private lateinit var valorAtualSlider:TextView;

    private lateinit var letrasMaiusculas:CheckBox;
    private lateinit var numeros:CheckBox;
    private lateinit var caracteresEspeciais:CheckBox;

    private lateinit var botaoConfirmar:Button;
    private lateinit var botaoCancelar:Button;
    private lateinit var botaoExcluir:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciador)

        this.titulo = findViewById(R.id.titulo);
        this.descricao = findViewById(R.id.descricao);

        //Configuracoes do Slider
        this.slider = findViewById(R.id.slider);
        this.slider.addOnChangeListener{view,value:Float,fromUser:Boolean ->
            this.valorAtualSlider.setText("${this.slider.value}")
        }

        this.valorMinimoSlider = findViewById(R.id.valorMinimoSlider);
        this.valorMinimoSlider.setText("${this.slider.valueFrom}")

        this.valorMaximoSlider = findViewById(R.id.valorMaximoSlider);
        this.valorMaximoSlider.setText("${this.slider.valueTo}")

        this.valorAtualSlider = findViewById(R.id.valorAtualSlider);
        this.valorAtualSlider.setText("${this.slider.value}")

        this.letrasMaiusculas = findViewById(R.id.letrasMaiusculas);
        this.numeros = findViewById(R.id.numeros);
        this.caracteresEspeciais = findViewById(R.id.caracteresEspeciais);

        this.botaoConfirmar = findViewById(R.id.botaoConfirmar);
        this.botaoConfirmar.setOnClickListener{confirmar()}

        this.botaoCancelar = findViewById(R.id.botaoCancelar);
        this.botaoCancelar.setOnClickListener{cancelar()}

        this.botaoExcluir = findViewById(R.id.botaoExcluir);

    }

    fun cancelar(){
        finish()
    }

    fun confirmar(){
        //A SENHA NÃO VAI SER CRIADA AQUI E SIM NO MAIN ACITIVITY ;-;
        val descricao = this.descricao.text.toString()
        val temLM = this.letrasMaiusculas.isActivated
        val temN = this.numeros.isActivated
        val temCS = this.caracteresEspeciais.isActivated
        val tamanho = this.slider.value.toInt()

        val intent = Intent().apply {
            putExtra("descricao",descricao)
            putExtra("temLM",temLM)
            putExtra("temN",temN)
            putExtra("temCS",temCS)
            putExtra("tamanho",tamanho)
        }

        setResult(RESULT_OK,intent)
        finish()

    }
}
