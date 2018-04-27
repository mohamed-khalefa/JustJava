/*
 *created by Mohamed Khalefa
 * GDG android Study Jam
 *Just Java App
 * 27/4/2018
 */


package com.example.devit.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static java.text.NumberFormat.getCurrencyInstance;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is used when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is used when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void sumOrder(View view) {
        // Get user's name
        EditText nameField = findViewById(R.id.EditTextID);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // check if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whippedCreamID);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // check if the user wants chocolate topping
        CheckBox chocolateCheckBox = findViewById(R.id.ChocolateID);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        // Display the order summary on the screen
        String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessege(message);


    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream determine if we need to  include whipped cream topping in the price
     * @param addChocolate    determine if we need to   include chocolate topping in the price
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        //  calculate the price of a cup of coffee
        int originalPrice = 5;

        // If the user wants whipped cream, we add $1 per cup
        if (addWhippedCream) {
            originalPrice = originalPrice + 1;
        }

        // If the user wants chocolate , we will add $2 per cup
        if (addChocolate) {
            originalPrice = originalPrice + 2;
        }

        // Calculate the total order price
        return quantity * originalPrice;
    }

    /**
     * Create summary of the order.
     *
     * @param name            on the order
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name : " + name;
        priceMessage += "\n\t" + "Add whipped cream ? " + addWhippedCream;
        priceMessage += "\n\t" + "Add Chocolate ? " + addChocolate;
        priceMessage += "\n\t" + "Quantity : " + quantity;
        priceMessage += "\n\t" + "Price : " + getCurrencyInstance().format(price);
        priceMessage += "\n\t" + "Thank you";
        return priceMessage;
    }

    private void displayMessege(String message) {

        TextView priceTextView = findViewById(R.id.priceViewID);
        priceTextView.setText(message);
    }

    /**
     * This method is used to display the given quantity values on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantityValueID);
        quantityTextView.setText(" " + numberOfCoffees);
    }
}


