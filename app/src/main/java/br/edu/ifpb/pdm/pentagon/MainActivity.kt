package br.edu.ifpb.pdm.pentagon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listinhaDeSenha: ListView;
    private lateinit var botaoNovaSenha: FloatingActionButton;
    private var senhas = mutableListOf<Senha>()

    private val gerenciadorResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            if(it.data != null){
                val descricao = it.data?.getStringExtra("descricao")
                val temLM = it.data?.getBooleanExtra("temLM",false)
                val temN = it.data?.getBooleanExtra("temN",false)
                val temCS = it.data?.getBooleanExtra("temCS",false)
                val tamanho = it.data?.getIntExtra("tamanho",4)
                this.senhas.add(Senha(descricao,temLM,temCS,temN,tamanho))
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.listinhaDeSenha = findViewById(R.id.listinhaDeSenhas);
        this.botaoNovaSenha = findViewById(R.id.botaoNovaSenha)

        this.listinhaDeSenha.adapter = ArrayAdapter<Senha>(this,android.R.layout.simple_list_item_1,this.senhas)

        this.botaoNovaSenha.setOnClickListener({irParaGerenciador()})
    }

    fun irParaGerenciador(){
        val intent = Intent(this, GerenciadorActivity::class.java);
        startActivity(intent)
    }
}