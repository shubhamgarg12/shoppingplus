package com.udacity.firebase.shoppinglistplusplus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;

/**
 * Created by shinu on 7/17/2017.
 */
public class ShoppingList {

    String listName;
    String owner;
    HashMap<String,Object> timestampCreated;
    HashMap<String,Object> timestampLastChanged;

    public ShoppingList() {
    }

    public ShoppingList(String owner, String listName,HashMap<String,Object> timestampCreated) {

        this.owner = owner;
        this.listName = listName;
        this.timestampCreated=timestampCreated;
        HashMap<String, Object> timestampNowObj = new HashMap<String, Object>();
        timestampNowObj.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
        this.timestampLastChanged = timestampNowObj;

    }

    public String getListName() {
        return listName;
    }

    public String getOwner() {
        return owner;
    }

    public HashMap<String, Object> getTimestampLastChanged() {
        return timestampLastChanged;
    }

    public HashMap<String,Object> getTimestampCreated(){  return timestampCreated; }

    @JsonIgnore
    public long getTimestampLastChangedLong() {

        return (long) timestampLastChanged.get(Constants.FIREBASE_PROPERTY_TIMESTAMP);
    }
    @JsonIgnore
    public long getTimestampCreatedLong() {

        return (long) timestampLastChanged.get(Constants.FIREBASE_PROPERTY_TIMESTAMP);
    }
}
