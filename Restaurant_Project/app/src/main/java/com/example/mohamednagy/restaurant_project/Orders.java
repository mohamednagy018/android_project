package com.example.mohamednagy.restaurant_project;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.mohamednagy.restaurant_project.Login.userData;


/**
 * A simple {@link Fragment} subclass.
 */
public class Orders extends Fragment {

    SQLiteDatabase sql;
    Database db;

    public Orders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container != null) {
            container.removeAllViewsInLayout();
        }
        View view =  inflater.inflate(R.layout.fragment_orders, container, false);
        sql = getActivity().openOrCreateDatabase("myDB",0,null);
        db = new Database(sql);
        ArrayList<String> ordersArr ;
        if((ordersArr =db.getUserOrder(userData)) !=null)
        {
            ListView orderList = (ListView) view.findViewById(R.id.orderList);
            ArrayAdapter<String> listOforder = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ordersArr);
            orderList.setAdapter(listOforder);
        }else
        {
            Toast.makeText(getActivity() , "THERE IS NO ORDERS !" , Toast.LENGTH_LONG).show();
        }

        return view;
    }

}
