package br.com.redewsouza.componentsandroid.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.redewsouza.componentsandroid.Holder.CardHolder;
import br.com.redewsouza.componentsandroid.Models.UserModel;
import br.com.redewsouza.componentsandroid.R;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private final List<UserModel> mUsers;

    public CardAdapter(ArrayList users) {
        //Recebe obj de Users
        mUsers = users;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla o layout da lista
        return new CardHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, final int position) {
        //Set titulo formatado com Nome, Idade - Cidade
        holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mUsers.get(position).getName(),
                mUsers.get(position).getAge(),
                mUsers.get(position).getCity()
        ));
        holder.desc.setText(mUsers.get(position).getDescription()); //Set descricao
        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateItem(position);
            }
        }); //Botao +
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerItem(position);
            }
        }); //botao de delete
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    private void insertItem(UserModel user) {
        //Funcao para add novo item a lista
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }

    private void updateItem(int position) {
        //Incrementa idade
        mUsers.get(position).incrementAge();
        notifyItemChanged(position);
    }

    private void removerItem(int position) {
        //Remover item
        mUsers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mUsers.size());
    }

    public void updateList(UserModel user) {
        //Atualizar lista apos alteracao
        insertItem(user);
    }
}
