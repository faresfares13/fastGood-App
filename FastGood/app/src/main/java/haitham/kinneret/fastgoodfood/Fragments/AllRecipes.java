package haitham.kinneret.fastgoodfood.Fragments;

import android.database.SQLException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;

import haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters.CustomAdapter;
import haitham.kinneret.fastgoodfood.DatabaseManager.DatabaseAccess;
import haitham.kinneret.fastgoodfood.R;


public class AllRecipes extends Fragment {

    GridView gridview;
    Bitmap bitmap = null;
    static final String DUMMY = "Dummy Text";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_all_recipes, container, false);


    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this.getActivity());
        databaseAccess.open();
        gridview = (GridView) view.findViewById(R.id.customgrid);
        gridview.setAdapter(new CustomAdapter(this.getActivity(), databaseAccess.getRecipeName(), databaseAccess.getImages()));
        databaseAccess.close();
    }

}
