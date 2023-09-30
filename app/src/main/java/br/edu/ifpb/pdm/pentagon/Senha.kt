package br.edu.ifpb.pdm.pentagon

class Senha {
    private var descricao : String;
    private lateinit var senha: String;
    constructor(descricao:String,temLM:Boolean,temCS:Boolean,temN:Boolean,tamanho: Int){
        this.descricao = descricao;
        gerarSenha(temLM,temCS,temN,tamanho)
    }

    fun gerarSenha(temLM:Boolean,temCS:Boolean,temN:Boolean,tamanho:Int){
        this.senha = "";
    }

    fun getDescricao():String{
        return this.descricao
    }

    fun setDescricao(novaDescricao:String){
        this.descricao = novaDescricao
    }

    fun getSenha():String{
        return this.senha;
    }
}