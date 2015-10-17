package project4.utility.com.utilityproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    boolean decimal_added = false;
    boolean equal_button_pressed = false;

    Button button_zero, button_one, button_two, button_three, button_four, button_five, button_six,
            button_seven, button_eight, button_nine, button_decimal, button_equal, button_delete,
            button_divide, button_multiply, button_subtract, button_add;

    TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Numbers
        button_zero = (Button) findViewById(R.id.button_0);
        button_one = (Button) findViewById(R.id.button_1);
        button_two = (Button) findViewById(R.id.button_2);
        button_three = (Button) findViewById(R.id.button_3);
        button_four = (Button) findViewById(R.id.button_4);
        button_five = (Button) findViewById(R.id.button_5);
        button_six = (Button) findViewById(R.id.button_6);
        button_seven = (Button) findViewById(R.id.button_7);
        button_eight = (Button) findViewById(R.id.button_8);
        button_nine = (Button) findViewById(R.id.button_9);

        button_decimal = (Button) findViewById(R.id.button_decimal);
        button_equal = (Button) findViewById(R.id.button_equal);
        button_delete = (Button) findViewById(R.id.button_delete);

        //Operators
        button_divide = (Button) findViewById(R.id.button_divide);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_subtract = (Button) findViewById(R.id.button_subtract);
        button_add = (Button) findViewById(R.id.button_plus);

        console = (TextView) findViewById(R.id.textview_console);

        button_zero.setOnClickListener(this);
        button_one.setOnClickListener(this);
        button_two.setOnClickListener(this);
        button_three.setOnClickListener(this);
        button_four.setOnClickListener(this);
        button_five.setOnClickListener(this);
        button_six.setOnClickListener(this);
        button_seven.setOnClickListener(this);
        button_eight.setOnClickListener(this);
        button_nine.setOnClickListener(this);
        button_decimal.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_equal.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (equal_button_pressed == true) {
            console.setText("");
            equal_button_pressed = false;
            decimal_added = false;
        }

        if (v.getId() == button_zero.getId()){
            console.setText(console.getText() + "0");
        } else if (v.getId() == button_one.getId()){
            console.setText(console.getText() + "1");
        } else if (v.getId() == button_two.getId()){
            console.setText(console.getText() + "2");
        } else if (v.getId() == button_three.getId()){
            console.setText(console.getText() + "3");
        } else if (v.getId() == button_four.getId()){
            console.setText(console.getText() + "4");
        } else if (v.getId() == button_five.getId()){
            console.setText(console.getText() + "5");
        } else if (v.getId() == button_six.getId()){
            console.setText(console.getText() + "6");
        } else if (v.getId() == button_seven.getId()){
            console.setText(console.getText() + "7");
        } else if (v.getId() == button_eight.getId()){
            console.setText(console.getText() + "8");
        } else if (v.getId() == button_nine.getId()){
            console.setText(console.getText() + "9");
        } else if (v.getId() == button_decimal.getId() && decimal_added == false){
            console.setText(console.getText() + ".");
            decimal_added = true;
        } else if (v.getId() == button_delete.getId()){
            console.setText("");
        } else if (v.getId() == button_divide.getId()){
            console.setText(console.getText() + "/");
        } else if (v.getId() == button_multiply.getId()){
            console.setText(console.getText() + "x");
        } else if (v.getId() == button_subtract.getId()){
            console.setText(console.getText() + "-");
        } else if (v.getId() == button_add.getId()){
            console.setText(console.getText() + "+");
        }  else if (v.getId() == button_equal.getId() && console.getText().length() >= 3){
            calculate(console.getText().toString());
            equal_button_pressed = true;
        }
    }

    public void calculate (String string) {
        int index = 0;
        String operandOne = "";
        String operandTwo = "";
        while (string.charAt(index) != '+' && string.charAt(index) != '-'
                && string.charAt(index) != 'x' && string.charAt(index) != '/') {
            operandOne += string.charAt(index);
            index++;
        }

        if (string.charAt(index) == '+') {
            index++;
            while (index != string.length()) {
                operandTwo += string.charAt(index);
                index++;
            }
            if (decimal_added == true) {
                double operand = Double.parseDouble(operandOne);
                double operand2 = Double.parseDouble(operandTwo);

                double calculation = operand + operand2;

                console.setText(Double.toString(calculation));
            } else if (decimal_added == false) {
                int operand = Integer.parseInt(operandOne);
                int operand2 = Integer.parseInt(operandTwo);

                int calculation = operand + operand2;

                console.setText(Integer.toString(calculation));
            }

        } else if (string.charAt(index) == '-') {
            index++;
            while (index != string.length()) {
                operandTwo += string.charAt(index);
                index++;
            }
            int operand = Integer.parseInt(operandOne);
            int operand2 = Integer.parseInt(operandTwo);

            int calculation = operand - operand2;

            console.setText(Integer.toString(calculation));
        } else if (string.charAt(index) == 'x') {
            index++;
            while (index != string.length()) {
                operandTwo += string.charAt(index);
                index++;
            }
            int operand = Integer.parseInt(operandOne);
            int operand2 = Integer.parseInt(operandTwo);

            int calculation = operand * operand2;

            console.setText(Integer.toString(calculation));
        } else if (string.charAt(index) == '/') {
            index++;
            while (index != string.length()) {
                operandTwo += string.charAt(index);
                index++;
            }
            int operand = Integer.parseInt(operandOne);
            int operand2 = Integer.parseInt(operandTwo);

            int calculation = operand / operand2;

            console.setText(Integer.toString(calculation));
        }
    }
}
