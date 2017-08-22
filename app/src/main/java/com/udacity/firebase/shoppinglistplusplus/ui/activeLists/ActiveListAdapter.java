package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;

/**
 * Created by shinu on 7/22/2017.
 */
public class ActiveListAdapter extends FirebaseListAdapter<ShoppingList> {


    public ActiveListAdapter(Activity activity, Class<ShoppingList> modelClass,int modelLayout,Query ref){

        super(activity,modelClass,modelLayout,ref);
        this.mActivity=activity;
    }
    protected void populateView(View view,ShoppingList list)
    {
        TextView textViewListName = (TextView) view.findViewById(R.id.text_view_list_name);

        TextView textViewCreatedByUser = (TextView) view.findViewById(R.id.text_view_created_by_user);

        textViewCreatedByUser.setText(list.getOwner());
        textViewListName.setText(list.getListName());
        //textViewCreatedByUser.setText("Sh");
        //textViewListName.setText("Shuba");


    }


}
