package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;

/**
 * Adds a new shopping list
 */
public class AddListDialogFragment extends DialogFragment {
    EditText mEditTextListName;
    String mEncodeEmail;

    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AddListDialogFragment newInstance(String encodeEmail) {
        AddListDialogFragment addListDialogFragment = new AddListDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ENCODED_EMAIL,encodeEmail);
        addListDialogFragment.setArguments(bundle);
        return addListDialogFragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mEncodeEmail= getArguments().getString(Constants.KEY_ENCODED_EMAIL);
    }

    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog);
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_add_list, null);
        mEditTextListName = (EditText) rootView.findViewById(R.id.edit_text_list_name);

        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        mEditTextListName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    addShoppingList();
                }
                return true;
            }
        });

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton(R.string.positive_button_create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addShoppingList();
                    }
                });

        return builder.create();
    }

    /**
     * Add new active list
     */
    public void addShoppingList() {

        String listNameEntered = mEditTextListName.getText().toString();


        if(!listNameEntered.equals("")) {

            DatabaseReference listRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_URL_ACTIVE_LISTS);


            DatabaseReference newListRef = listRef.push();

            // get a unique id for the new List entered using listref.push()
            final String listId = newListRef.getKey();

            HashMap<String, Object> timestampCreated = new HashMap<>();

            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            ShoppingList newShoppingList = new ShoppingList(mEncodeEmail,listNameEntered,timestampCreated);

            newListRef.setValue(newShoppingList);

            AddListDialogFragment.this.getDialog().cancel();

        }
    }

}

