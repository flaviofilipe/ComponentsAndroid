package br.com.flaviofilipe.componentsandroid.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.flaviofilipe.componentsandroid.R;

/**
 * Created by Windows 10 Pro on 04/08/2017.
 */

public class CardHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView desc;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public CardHolder(View itemView) {
        //Pega itens do layout
        super(itemView);
        title = itemView.findViewById(R.id.main_card_title);
        moreButton =  itemView.findViewById(R.id.main_card_more);
        deleteButton = itemView.findViewById(R.id.main_card_delete);
        desc = itemView.findViewById(R.id.main_card_desc);
    }
}
