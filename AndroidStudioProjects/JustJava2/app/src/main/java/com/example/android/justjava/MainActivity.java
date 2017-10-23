package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

        import java.text.NumberFormat;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import static android.R.attr.name;
        import static android.R.attr.value;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        if(quantity==100) {
            Toast.makeText(this,"You couldn't have more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {

        if (quantity==1) {
            Toast.makeText(this,"You couldn't have less than 1 coffees",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    private String createOrderSummery(String name,int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage= "Name: "+ name+"\n";
        priceMessage+="Add whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: "+ quantity;
        priceMessage=priceMessage+"\nTotal $" +  price;
        priceMessage= priceMessage + "\nThank you!";
        return priceMessage;
    }

    public void submitOrder(View view) {

        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox =(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream =whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price =calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage= createOrderSummery(name,price,hasWhippedCream,hasChocolate);

         Intent intent = new Intent(Intent.ACTION_SENDTO);
         intent.setData(Uri.parse("mailto:")); // only email apps should handle this
         intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name );
         intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
         if (intent.resolveActivity(getPackageManager()) != null) {
         startActivity(intent);
          }



    }
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        return quantity*basePrice;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbers);
    }

    /**
     * This method displays the given text on the screen.
     */

}