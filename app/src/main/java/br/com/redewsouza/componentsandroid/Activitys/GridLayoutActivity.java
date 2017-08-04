package br.com.redewsouza.componentsandroid.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import br.com.redewsouza.componentsandroid.Adapters.CardAdapter;
import br.com.redewsouza.componentsandroid.Models.UserModel;
import br.com.redewsouza.componentsandroid.R;

public class GridLayoutActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    FloatingActionButton mFab;
    Toolbar mToolbar;
    Button btnAddTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_GridMain);
        mToolbar = (Toolbar) findViewById(R.id.recycler_view_layour_toolbar);
        btnAddTeste = (Button) findViewById(R.id.btn_addTeste);
        btnAddTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel user2 = new UserModel("Filipe","Brumado","Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao ",20); //Cria user
                mAdapter.updateList(user2); //Insere na lista
            }
        });

        setupView();
        setupRecycler();
    }

    private void setupView() {
        //tool bar e botao de add novo item
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Inserindo novo item na lista
        UserModel user1 = new UserModel("Flávio Filipe","Brumado","Descricao",20); //Cria user
        mAdapter.updateList(user1); //Insere na lista
    }

    private void setupRecycler() {

        // Criando o GridLayoutManager com duas colunas, descritas no segundo argumento.
        int numberOfColumns = 2; //Num de colunas
        //StaggeredGridLayoutManager organiza os itens automaticamente na tela
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(numberOfColumns, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        /* Não Organiza os itens automaticamente na tela
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        mRecyclerView.setLayoutManager(layoutManager);
        */

        // Adiciona o adapter que irá anexar os objetos à lista.
        mAdapter = new CardAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);
    }

}
