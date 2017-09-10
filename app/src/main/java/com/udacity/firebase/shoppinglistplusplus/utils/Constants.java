package com.udacity.firebase.shoppinglistplusplus.utils;

import com.udacity.firebase.shoppinglistplusplus.BuildConfig;

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where active lists are stored (ie "activeLists")
     */
    public static final String FIREBASE_PROPERTY_LIST_NAME = "listName";

    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;

    public static final String FIREBASE_LOCATION_ACTIVE_LIST = "activeList";

    public static final String FIREBASE_LOCATION_ACTIVE_LISTS = "activeLists";

    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";

    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED = "timestampLastChanged";

    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";

    public static final String KEY_LIST_NAME = "LIST_NAME";

    public static final String FIREBASE_URL_ACTIVE_LIST = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_LIST;

    public static final String FIREBASE_URL_ACTIVE_LISTS = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_LISTS;

    public static final String KEY_LIST_ID = "LIST_ID";

    public static final String KEY_LIST_ITEM_ID = "ITEM_ID";

    public static final String KEY_LIST_ITEM_NAME = "ITEM_NAME";

    public static final String FIREBASE_LOCATION_SHOPPING_LIST_ITEMS = "shoppingListItems";

    public static final String FIREBASE_PROPERTY_ITEM_NAME = "itemName";

    public static final String FIREBASE_URL_SHOPPING_LIST_ITEMS = FIREBASE_URL + "/" + FIREBASE_LOCATION_SHOPPING_LIST_ITEMS;

    public static final String PASSWORD_PROVIDER = "password";

    public static final String GOOGLE_PROVIDER = "google,com";

    public static final String FIREBASE_LOCATION_USERS = "users";

    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;

    public static final String KEY_PROVIDER = "PROVIDER";

    public static final String KEY_ENCODED_EMAIL = "ENCODED_EMAIL";

    public static final String KEY_LIST_OWNER = "LIST_OWNER";

    public static final String FIREBASE_PROPERTY_EMAIL = "email";

    public static final String KEY_GOOGLE_EMAIL = "GOOGLE_EMAIL";

    public static final String UserName = "userName";
    /**
     * Constants for Firebase object properties
     */


    /**
     * Constants for Firebase URL
     */


    /**
     * Constants for bundles, extras and shared preferences keys
     */


}
