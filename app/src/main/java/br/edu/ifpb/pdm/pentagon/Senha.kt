package br.edu.ifpb.pdm.pentagon

class Senha {
    private var descricao : String;
    private lateinit var senha: String;
    private val intervaloDeLetrasMinusculas : CharRange = ('a'..'z')
    private val intervaloDeLetrasMaiusculas : CharRange = ('A'..'Z')
    private val intervaloDeNumeros : CharRange = ('0'..'9')
    private val caracteresEspeciais : CharArray = "!@#$%*-+=(){}[]".toCharArray()

    constructor(descricao:String,temLM:Boolean,temCS:Boolean,temN:Boolean,tamanho: Int){
        this.descricao = descricao;
        gerarSenha(temLM,temCS,temN,tamanho)
    }

    fun gerarSenha(temLM:Boolean,temCS:Boolean,temN:Boolean,tamanho:Int){
        var listaDeCaracteres = mutableListOf<Char>()

        for(caractere in intervaloDeLetrasMinusculas){
            listaDeCaracteres.add(caractere)
        }

        if(temLM){
            for(caractere in intervaloDeLetrasMaiusculas){
                listaDeCaracteres.add(caractere)
            }
        }

        if (temN){
            for(caractere in intervaloDeNumeros){
                listaDeCaracteres.add(caractere)
            }
        }

        if(temCS){
            for(caractere in caracteresEspeciais){
                listaDeCaracteres.add(caractere)
            }
        }

        this.senha = List(tamanho) { listaDeCaracteres.random() }.joinToString("")
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