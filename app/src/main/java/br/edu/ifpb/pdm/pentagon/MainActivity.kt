package br.edu.ifpb.pdm.pentagon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnLongClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listinhaDeSenha: ListView;
    private lateinit var botaoNovaSenha: FloatingActionButton;
    private var senhas = mutableListOf<Senha>()
    private var caracteres = mutableListOf<String>()

    private val gerenciadorResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            if(it.data != null){
                val descricao = it.data?.getStringExtra("descricao")
                val temLM = it.data?.getBooleanExtra("temLM",false)
                val temN = it.data?.getBooleanExtra("temN",false)
                val temCS = it.data?.getBooleanExtra("temCS",false)
                val tamanho = it.data?.getIntExtra("tamanho",4)

                Log.i("VALORES","${temCS} - ${temLM} - ${temN}")
                val senha = Senha(descricao,temLM,temCS,temN,tamanho)
                this.senhas.add(senha)
                Log.i("SENHA","${senha.getSenha()}")
                Log.i("TAMANHO","${this.senhas.size}")
                atualizarLista("${descricao} (${tamanho})")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.listinhaDeSenha = findViewById(R.id.listinhaDeSenhas);
        this.botaoNovaSenha = findViewById(R.id.botaoNovaSenha)

        this.listinhaDeSenha.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.caracteres)
        this.listinhaDeSenha.setOnLongClickListener{pegarSenha()}
        this.listinhaDeSenha.setOnClickListener {editarSenha()}

        this.botaoNovaSenha.setOnClickListener({irParaGerenciador()})
    }

    fun irParaGerenciador(){
        val intent = Intent(this, GerenciadorActivity::class.java);
        this.gerenciadorResult.launch(intent)
    }

    fun atualizarLista(texto:String){
        (this.listinhaDeSenha.adapter as ArrayAdapter<String>).add(texto)
    }

    inner class OnLongClickItem: OnLongClickListener(){
       override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long):Boolean{
           this@MainActivity.caracteres.get(p2)
           return true
       }
    }
}