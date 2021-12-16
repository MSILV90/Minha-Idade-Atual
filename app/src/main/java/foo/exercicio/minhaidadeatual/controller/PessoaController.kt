package foo.exercicio.minhaidadeatual.controller

import foo.exercicio.minhaidadeatual.model.Pessoa
import java.time.LocalDate

class PessoaController(objetoPessoa: Pessoa) {

    var pessoa: Pessoa = objetoPessoa

    fun mostrarResultado(): String{
        return "${this.pessoa.primeiroNome}, ${this.pessoa.anoNascimento}"
    }

    fun calcularIdadeEmAnos(anoAtual: Int): Int{

        return anoAtual - this.pessoa.anoNascimento
    }

    fun calcularIdadeEmAnos(): Int{

        val anoAtual = LocalDate.now().year

        return anoAtual - this.pessoa.anoNascimento
    }


}