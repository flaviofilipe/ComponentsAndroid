package br.com.redewsouza.componentsandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.redewsouza.componentsandroid.R;

/**
 * Created by fx2 on 27/02/18.
 */

public class TabFrag2 extends Fragment {

    //Tela do fragment 2
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag2,container,false);

    }
}
