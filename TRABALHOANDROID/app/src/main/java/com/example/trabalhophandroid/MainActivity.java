package com.example.trabalhophandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextCPF;
    private Button btnCadastrarCliente;
    private EditText edTextCodItem;
    private EditText edTextValorUnitario;
    private Button btCadastrarItem;
    private EditText edQuantidade;
    private EditText edNumeroParcelas;
    private Button btAdicionarItens;
    private Button btConclusaoPedido;
    private TextView txtViewItensPedido;
    private TextView txtValorItem;
    private Spinner spClientes;
    private Spinner spItem;
    private List<String> listViewItens;
    private RadioGroup RGPagamento;
    private RadioButton RBaVista;
    private RadioButton rbParcelado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextCPF = findViewById(R.id.editTextCPF);
        btnCadastrarCliente = findViewById(R.id.btnCadastrarCliente);
        edTextCodItem = findViewById(R.id.edTextCodItem);
        edTextValorUnitario = findViewById(R.id.edTextValorUnitario);
        btCadastrarItem = findViewById(R.id.btCadastrarItem);
        edQuantidade = findViewById(R.id.edQuantidade);
        edNumeroParcelas = findViewById(R.id.edNumeroParcelas);
        btAdicionarItens = findViewById(R.id.btAdicionarItens);
        btConclusaoPedido = findViewById(R.id.btConclusaoPedido);
        txtViewItensPedido = findViewById(R.id.txtViewItensPedido);
        txtValorItem = findViewById(R.id.txtValorItem);
        spClientes = findViewById(R.id.spClientes);
        spItem = findViewById(R.id.spItem);
        listViewItens = findViewById(R.id.listViewItens);
        RGPagamento = findViewById(R.id.RGPagamento);
        RBaVista = findViewById(R.id.RBaVista);
        rbParcelado = findViewById(R.id.rbParcelado);

        ArrayList<Object> clientes = new ArrayList<>();
        clientes.add("cliente 1");
        clientes.add("cliente 2");
        clientes.add("cliente 3");

        ArrayList<Object> itens = new ArrayList<>();
        itens.add("item 1");
        itens.add("item 2");
        itens.add("item 3");

        listViewItens = new ArrayList<>();
        ArrayAdapter<String> clientesAdp =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, clientes);
        clientesAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClientes.setAdapter(clientesAdp);

        ArrayAdapter<String> itensAdp =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itens);
        itensAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spItem.setAdapter(itensAdp);

        RGPagamento.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
       @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
           if(checkedId == R.id.rbParcelado){
               edNumeroParcelas.setVisibility(view.VISIBLE);
           }else{
               edNumeroParcelas.setVisibility(view.GONE);
           }
       }
        });

        btAdicionarItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String itemSelecionado = spItem.getSelectedItem().toString();
                String quantidadeStr = edQuantidade.getText().toString();

                if(!quantidadeStr.isEmpty()){
                    int quantidade = integer.parseInt(quantidadeStr);
                    String itempedido = itemSelecionado + " X " + quantidade;
                    itenPedido.add(itempedido);
                    updadeItensPedidoView();
                }
            }
        });
    }
}