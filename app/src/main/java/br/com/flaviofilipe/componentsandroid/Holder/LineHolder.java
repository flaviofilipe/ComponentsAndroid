package br.com.flaviofilipe.componentsandroid.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.flaviofilipe.componentsandroid.R;

/**
 * Created by Windows 10 Pro on 04/08/2017.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        //Pega itens do layout
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.main_line_title);
        moreButton = (ImageButton) itemView.findViewById(R.id.main_line_more);
        deleteButton = (ImageButton) itemView.findViewById(R.id.main_line_delete);
    }
}
