package br.com.redewsouza.componentsandroid.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import br.com.redewsouza.componentsandroid.Adapters.LineAdapter;
import br.com.redewsouza.componentsandroid.Models.UserModel;
import br.com.redewsouza.componentsandroid.R;

public class LinearLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    private LineAdapter mAdapter;
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_LinearMain);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupView();
        setupRecycler();
    }

    private void setupView() {
        //botao add novo item
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Inserindo novo item na lista
        UserModel user2 = new UserModel("Flávio Filipe","Brumado","Descricao",20); //Cria user
        mAdapter.updateList(user2); //Insere na lista
    }

    private void setupRecycler() {

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        mAdapter = new LineAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

}
