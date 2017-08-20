package com.udacity.firebase.shoppinglistplusplus.ui.activeListDetails;

/**
 * Created by shinu on 7/18/2017.
 */

import android.app.Dialog;
import android.os.Bundle;

import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;

/**
 * Lets user edit the list name for all copies of the current list
 */
public class EditListNameDialogFragment extends EditListDialogFragment {
    private static final String LOG_TAG = ActiveListDetailsActivity.class.getSimpleName();
    String mListName;
    /**
     * Public static constructor that creates fragment and passes a bundle with data into it when adapter is created
     */
    public static EditListNameDialogFragment newInstance(ShoppingList shoppingList,String listId) {
        EditListNameDialogFragment editListNameDialogFragment = new EditListNameDialogFragment();
        Bundle bundle = EditListDialogFragment.newInstanceHelper(shoppingList, R.layout.dialog_edit_list,listId);

        // TODO add any values you need here from the shopping list to make this change.
        // Once you put a value in the bundle, it available to you in onCreate
        bundle.putString(Constants.KEY_LIST_NAME,shoppingList.getListName());
        editListNameDialogFragment.setArguments(bundle);
        return editListNameDialogFragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // TODO Extract any arguments you put in the bundle when the newInstance method
        // created the dialog. You can store these in an instance variable so that they
        // are available to you.
        super.onCreate(savedInstanceState);
        mListName=getArguments().getString(Constants.KEY_LIST_NAME);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /** {@link EditListDialogFragment#createDialogHelper(int)} is a
         * superclass method that creates the dialog
         **/
        Dialog dialog = super.createDialogHelper(R.string.positive_button_edit_item);

       // TODO You can use the helper method in the superclass I made (EditListDialogFragment)
        // called helpSetDefaultValueEditText. This will allow you to set what text the
        // user sees when the dialog opens.
        helpSetDefaultValueEditText(mListName);
        return dialog;
    }

    /**
     * Changes the list name in all copies of the current list
     */
    protected void doListEdit() {
        // TODO Do the actual edit operation here.
        // Remember, you need to update the timestampLastChanged for
        // the shopping list.
        String mInputListName=mEditTextForList.getText().toString();

        if(!mInputListName.equals("")) {
            if (mListName != null&&mListId!=null) {
                if (!mInputListName.equals(mListName)) {
                    Firebase refShoppingList = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);
                    HashMap<String, Object> updatedProps = new HashMap<>();
                    updatedProps.put(Constants.KEY_LIST_NAME, mInputListName);
                    HashMap<String, Object> changedTimesSTamp = new HashMap<>();
                    changedTimesSTamp.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
                    updatedProps.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, changedTimesSTamp);
                    refShoppingList.updateChildren(updatedProps);
                }
            }
        }
    }
}
