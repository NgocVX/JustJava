package com.ngoc_vx.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 0;
    private int priceOfOneCoffee = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMessage("Free");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = this.quantity * this.priceOfOneCoffee;
        String priceMessage = "Total: " + price + "VND\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method is called when plus button is clicked.
     * Increment number of Coffees.
     *
     * @param view
     */
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     * Decrement number of Coffees.
     *
     * @param view
     */
    public void decrement(View view) {
        quantity--;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
