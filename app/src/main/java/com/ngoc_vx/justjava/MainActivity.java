package com.ngoc_vx.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private int priceOfOneCoffee = 5;
    private int priceWhippedCream = 1;
    private int priceChocolate = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
        //displayMessage("Free");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameEditText = findViewById(R.id.name_editText);
        Editable name =  nameEditText.getText();
        //Log.v("MainActivity", "Name: " +name);

        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        //Log.v("MainActivity", "Has Whipped Cream "+hasWhippedCream);

        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when plus button is clicked.
     * Increment number of Coffees.
     *
     * @param view
     */
    public void increment(View view) {
        if (quantity >= 100){
            // show error message
            Toast.makeText(this, "You can not oder over 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     * Decrement number of Coffees.
     *
     * @param view
     */
    public void decrement(View view) {
        if (quantity < 2) {
            // show error message
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }

        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /*  *//**
     * This method displays the given price on the screen.
     *//*
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
*/

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order base on the current quantity
     *
     * @return the price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int pricePerCup = this.priceOfOneCoffee;

        if (addWhippedCream) {
            pricePerCup += this.priceWhippedCream;
        }

        if (addChocolate) {
            pricePerCup += this.priceChocolate;
        }
        return pricePerCup*quantity;
    }

    /**
     * Create message to display
     *
     * @param totalPrice of order
     * @return message display
     */
    private String createOrderSummary(Editable name, int totalPrice, boolean addWhippedCream, boolean addChocolate) {
        String orderSummary = "Name: "+ name;
        orderSummary += "\nAdd whipped cream? " + addWhippedCream;
        orderSummary += "\nAdd chocolate? " + addChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: $" + totalPrice;
        orderSummary += "\nThank you!";
        return orderSummary;
    }
}
