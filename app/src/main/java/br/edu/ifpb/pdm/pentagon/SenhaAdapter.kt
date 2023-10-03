package br.edu.ifpb.pdm.pentagon

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class SenhaAdapter (var contexto : Context, var listaDeSenhas: MutableList<Senha>): BaseAdapter() {
    override fun getCount(): Int {
        return this.listaDeSenhas.size
    }

    override fun getItem(posicao: Int): Any {
        return this.listaDeSenhas.get(posicao)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(posicao: Int, view: View?, viewGroup: ViewGroup?): View {

    }

    fun adicionar(novaSenha: Senha){
        this.listaDeSenhas.add(novaSenha)
        notifyDataSetChanged()
    }
}