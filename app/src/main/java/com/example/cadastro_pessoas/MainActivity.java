package com.example.cadastro_pessoas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLimpar, btnCadastro, btnVoltar, btnFinalizar;

    String nome, rg, cpf, cep, cnpj;

    TextView edNome  , edRg  , edCpf  , edCep  , edObs, edCNPJ;

    RadioButton rbPessoaJuridica, rbPessoaFisica;
    RadioGroup rgTipoPessoa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarregarTelaPrincipal();

    }

    private void CarregarTelaPrincipal()
    {
        setContentView(R.layout.activity_main);

        edNome = (TextView) findViewById(R.id.edNome);
        edRg = (TextView) findViewById(R.id.edRg);
        edCpf = (TextView) findViewById(R.id.edCpf);
        edCep = (TextView) findViewById(R.id.edCep);

        rbPessoaFisica = (RadioButton) findViewById(R.id.rbPessoaFisica);
        rbPessoaJuridica = (RadioButton) findViewById(R.id.rbPessoaJuridica);

        rgTipoPessoa = (RadioGroup) findViewById(R.id.rgTipoPessoa);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNome.setText(" ");
                edRg.setText(" ");
                edCpf.setText(" ");
                edCep.setText(" ");
                rgTipoPessoa.clearCheck();
            }
        });

        btnCadastro = findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int op = rgTipoPessoa.getCheckedRadioButtonId();

                if(op == R.id.rbPessoaFisica)
                {
                    if(edNome.length() < 2 || edRg.length() < 2 || edCpf.length() < 2 || edCep.length() < 2)
                    {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Atenção!");
                        alert.setMessage("Verificar campo vazio");
                        alert.setNeutralButton("Fechar",null);
                        alert.show();
                    }
                    else
                    {
                        nome = edNome.getText().toString();
                        rg = edRg.getText().toString();
                        cpf = edCpf.getText().toString();
                        cep = edCep.getText().toString();

                        CarregarTelaPessoaFisica();
                    }

                }
                if(op == R.id.rbPessoaJuridica)
                {
                    if(edNome.length() < 2 || edRg.length() < 2 || edCpf.length() < 2 || edCep.length() < 2)
                    {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Atenção!");
                        alert.setMessage("Verificar campo vazio");
                        alert.setNeutralButton("Fechar",null);
                        alert.show();
                    }
                    else
                    {
                        nome = edNome.getText().toString();
                        rg = edRg.getText().toString();
                        cpf = edCpf.getText().toString();
                        cep = edCep.getText().toString();

                        CarregarTelaPessoaJuridica();
                    }

                }
            }
        });
    }

    public void CarregarTelaPessoaFisica()
    {
        setContentView(R.layout.pessoa_fisica);

        edNome = (TextView) findViewById(R.id.edNome);
        edNome.setText(nome);
        edRg = (TextView) findViewById(R.id.edRg);
        edRg.setText(rg);
        edCpf = (TextView) findViewById(R.id.edCpf);
        edCpf.setText(cpf);
        edCep = (TextView) findViewById(R.id.edCep);
        edCep.setText(cep);
        edObs = (TextView) findViewById(R.id.edObs);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edNome.length() < 2 || edRg.length() < 2 || edCpf.length() < 2 || edCep.length() < 2)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Atenção!");
                    alert.setMessage("Verificar campo vazio");
                    alert.setNeutralButton("Fechar",null);
                    alert.show();
                }
                else
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle(edNome.getText() + " Cadastrado");
                    alert.setMessage("CPF: " + edCpf.getText()+"\n"+ "RG: " + edRg.getText() + "\n"+"CEP: " + edCep.getText());
                    alert.setNeutralButton("Fechar",null);
                    alert.show();
                }

                nome = " ";
                rg = " ";
                cpf = " ";
                cep = " ";

            }
        });

    }

    public void CarregarTelaPessoaJuridica()
    {
        setContentView(R.layout.pessoa_juridica);

        edNome = (TextView) findViewById(R.id.edNomepj);
        edNome.setText(nome);
        edRg = (TextView) findViewById(R.id.edRgpj);
        edRg.setText(rg);
        edCpf = (TextView) findViewById(R.id.edCpfpj);
        edCpf.setText(cpf);
        edCep = (TextView) findViewById(R.id.edCeppj);
        edCep.setText(cep);

        edCNPJ = (TextView) findViewById(R.id.edCNPJ);
        cnpj = edCNPJ.getText().toString();
        edObs = (TextView) findViewById(R.id.edObspj);


        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cnpj.length() < 3)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle(edNome.getText() + " Cadastrado");
                    alert.setMessage("CPF: " + edCpf.getText() + "\n" + "RG: " + edRg.getText() + "\n"+ "CEP:" + edCep.getText() + "\nCNPJ: " + edCNPJ.getText());
                    alert.setNeutralButton("Fechar",null);
                    alert.show();
                }

                nome = " ";
                rg = " ";
                cpf = " ";
                cep = " ";
            }
        });
    }
}