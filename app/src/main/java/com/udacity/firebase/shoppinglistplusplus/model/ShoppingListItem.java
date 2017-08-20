package com.udacity.firebase.shoppinglistplusplus.model;

/**
 * Created by shinu on 7/23/2017.
 */
// TODO Create this class.
    // Don't forget the rules for creating a POJO for Firebase.
    public class ShoppingListItem   {
          private String itemName;
            private String owner;

            /**
 +     * Required public constructor
 +     */
            public ShoppingListItem() {
            }

            /**
 +     * Use this constructor to create new ShoppingListItem.
 +     *
 +     * @param itemName
 +     */
            public ShoppingListItem(String itemName) {
                this.itemName = itemName;
                /**
 +         * This is a default value until we can differentiate users.
 +         * Which will be soon, I promise.
 +         */
                this.owner = "Anonymous Owner";
            }

            public String getItemName() { return itemName; }

            public String getOwner() {
                return owner;
            }

        }