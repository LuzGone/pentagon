package br.edu.ifpb.pdm.pentagon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listinhaDeSenha: ListView;
    private lateinit var botaoNovaSenha: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.listinhaDeSenha = findViewById(R.id.listinhaDeSenhas);
        this.botaoNovaSenha = findViewById(R.id.botaoNovaSenha)

        this.botaoNovaSenha.setOnClickListener({irParaGerenciador()})
    }

    fun irParaGerenciador(){
        val intent = Intent(this, GerenciadorActivity::class.java);
        startActivity(intent)
    }
}