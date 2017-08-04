package br.com.redewsouza.componentsandroid.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.redewsouza.componentsandroid.Holder.LineHolder;
import br.com.redewsouza.componentsandroid.Models.UserModel;
import br.com.redewsouza.componentsandroid.R;

public class LineAdapter extends RecyclerView.Adapter<LineHolder>  {
     private final List<UserModel> mUsers;

    public LineAdapter(ArrayList users) {
        mUsers = users;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Retorna o layout criado pelo ViewHolder
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position) {
        //Recebe ViewHolder e a posição da lista. Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
        holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mUsers.get(position).getName(),
                mUsers.get(position).getAge(),
                mUsers.get(position).getCity()
        ));

        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateItem(position);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Método que deverá retornar quantos itens há na lista.
        return mUsers != null ? mUsers.size() : 0;
    }

    public void updateList(UserModel user) {
        insertItem(user);
    }

    // Método responsável por inserir um novo usuário na lista e notificar que há novos itens.
    private void insertItem(UserModel user) {
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }

    // Método responsável por atualizar um usuário já existente na lista.
    private void updateItem(int position) {
        UserModel userModel = mUsers.get(position);
        userModel.incrementAge();
        notifyItemChanged(position);
    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {
        mUsers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mUsers.size());
    }
}
