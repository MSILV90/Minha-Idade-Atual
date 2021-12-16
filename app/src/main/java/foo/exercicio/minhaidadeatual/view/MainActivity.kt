package foo.exercicio.minhaidadeatual.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import foo.exercicio.minhaidadeatual.R
import foo.exercicio.minhaidadeatual.controller.PessoaController
import foo.exercicio.minhaidadeatual.model.Pessoa
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    lateinit var editPrimeiroNome: EditText
    lateinit var editAnoNascimento: EditText
    lateinit var btnCalcularIdade: Button
    lateinit var btnNovoCalculo: Button
    lateinit var txtResultado: TextView
    lateinit var btnSair: Button
    lateinit var objetoPessoa: Pessoa
    lateinit var pessoaController: PessoaController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponentes()
        initButtonClick()

    }


    private fun initComponentes() {

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome)
        editAnoNascimento = findViewById(R.id.editAnoNascimento)
        btnCalcularIdade = findViewById(R.id.btnCalcularIdade)
        btnNovoCalculo = findViewById(R.id.btnNovoCalculo)
        txtResultado = findViewById(R.id.txtResultado)
        btnSair = findViewById(R.id.btnSair)


        objetoPessoa = Pessoa()

        pessoaController = PessoaController(objetoPessoa)

        txtResultado.setText("Aplicativo Inicializado com Sucesso")

    }

    private fun initButtonClick() {

        btnSair.setOnClickListener {
            Toast.makeText(this, "Clicado no botão sair...", Toast.LENGTH_LONG).show()

            finish()
        }

        btnNovoCalculo.setOnClickListener {
            editPrimeiroNome.setText("")
            editAnoNascimento.setText("")
            txtResultado.text = ""


        }

        btnCalcularIdade.setOnClickListener {

            var validacao = true

            if (editPrimeiroNome.text.isEmpty()) {
                validacao = false
                editPrimeiroNome.error = "Campo Nome Obrigatório!"
                editPrimeiroNome.requestFocus()
            }

            if (editAnoNascimento.text.isEmpty()) {
                validacao = false
                editAnoNascimento.error = "Campo Ano Nascimento Obrigatório!"
                editAnoNascimento.requestFocus()
            }

            if (validacao) {

                val anoNascimento = editAnoNascimento.text.toString().toInt()
                var primeiroNome = editPrimeiroNome.text.toString()

                objetoPessoa.primeiroNome = primeiroNome
                objetoPessoa.anoNascimento = anoNascimento

                val anosDeVida = pessoaController.calcularIdadeEmAnos()

                txtResultado.setText("${objetoPessoa.primeiroNome}, você tem $anosDeVida anos de vida")


            }

        }


    }
}