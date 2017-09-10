package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.ui.activeListDetails.ActiveListDetailsActivity;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;
import com.udacity.firebase.shoppinglistplusplus.utils.Utils;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass that shows a list of all shopping lists a user can see.
 * Use the {@link ShoppingListsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingListsFragment extends Fragment {

    private ListView mListView;
    //private TextView mTextViewListName;
    //private TextView mTextViewListOwner;
    //private TextView mTextViewEditTime;
    private ActiveListAdapter mActiveListAdapter;

    public ShoppingListsFragment() {
        /* Required empty public constructor */
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static ShoppingListsFragment newInstance() {
        ShoppingListsFragment fragment = new ShoppingListsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Initalize
         * UI elements
         */
        View rootView = inflater.inflate(R.layout.fragment_shopping_lists, container, false);
        initializeScreen(rootView);
        DatabaseReference activeListsRef = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.FIREBASE_URL_ACTIVE_LISTS);

        mActiveListAdapter = new ActiveListAdapter(getActivity(), ShoppingList.class, R.layout.single_active_list, activeListsRef);
        mListView.setAdapter(mActiveListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                ShoppingList selectedList =mActiveListAdapter.getItem(position);
                if(selectedList!=null){

                    Intent intent = new Intent(getActivity(),ActiveListDetailsActivity.class);
                    String listId = mActiveListAdapter.getRef(position).getKey();
                    intent.putExtra(Constants.KEY_LIST_ID,listId);
                    startActivity(intent);
                    //finish();

                }

            }
        });
        return rootView;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mActiveListAdapter.cleanup();
    }


    /**
     * Link listView elements from XML
     */
    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);
    }
}