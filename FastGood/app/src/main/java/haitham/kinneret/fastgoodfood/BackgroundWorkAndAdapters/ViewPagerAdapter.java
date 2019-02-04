package haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters;

/**
 * Created by Haitham + Fares on 1/16/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import haitham.kinneret.fastgoodfood.Fragments.AllRecipes;
import haitham.kinneret.fastgoodfood.Fragments.QuickAndEasy;
import haitham.kinneret.fastgoodfood.Fragments.SlowCooker;
import haitham.kinneret.fastgoodfood.Fragments.Vegan;
import haitham.kinneret.fastgoodfood.Fragments.Vegetarian;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new AllRecipes();
        } else if (position == 1) {
            return new Vegetarian();
        } else if(position == 2) {
            return new Vegan();
        }else if(position==3){
            return new QuickAndEasy();
        }else return new SlowCooker();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
