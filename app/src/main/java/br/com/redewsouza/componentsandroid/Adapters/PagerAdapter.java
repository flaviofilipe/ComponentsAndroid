package br.com.redewsouza.componentsandroid.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import br.com.redewsouza.componentsandroid.Fragments.TabFrag1;
import br.com.redewsouza.componentsandroid.Fragments.TabFrag2;

/**
 * Created by fx2 on 27/02/18.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    int mNumofTabs;
    public PagerAdapter(FragmentManager fm, int mNumofTabs) {
        super(fm);
        this.mNumofTabs = mNumofTabs;
    }

    //Captura o tem selecionado no menu
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TabFrag1 tab1 = new TabFrag1();
                Log.i("Frag 1", "Frag 1 ok");
                return tab1;
            case 1:
                TabFrag2 tab2 = new TabFrag2();
                Log.i("Frag 2", "Frag 2 ok");
                return tab2;
            default:
                Log.i("Default", "Return Default");
                return null;
        }
    }

    @Override
    public int getCount() {
        //Retorna a posiçoã do item
        return mNumofTabs;
    }
}
