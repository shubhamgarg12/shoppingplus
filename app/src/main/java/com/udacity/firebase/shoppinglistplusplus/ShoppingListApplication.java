package com.udacity.firebase.shoppinglistplusplus;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;

/**
 * Includes one-time initialization of Firebase related code
 */
public class ShoppingListApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // FirebaseApp//.setAndroidContext(this);
        //FirebaseDatabase.//getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
    }

}