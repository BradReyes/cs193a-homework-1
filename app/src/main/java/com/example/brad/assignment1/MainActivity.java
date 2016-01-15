package com.example.brad.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int random_number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random_number = get_random_number();
    }

    public void guess(View view) {
        EditText num = (EditText) findViewById(R.id.guessbox);
        TextView hint = (TextView) findViewById(R.id.hints);
        String value = num.getText().toString().trim();
        if (!is_int(value)) {
            hint.setText("Not a number, moron");
            return;
        }
        int guess = Integer.parseInt(value);
        if (guess < random_number) {
            hint.setText("Consider guessing a larger number");
        } else if (guess > random_number) {
            hint.setText("You should guess something smaller");
        } else {
            hint.setText("You got it! Another number has been randomly selected");
            random_number = get_random_number();
        }
    }

    public void giveup(View view) {
        TextView hint = (TextView) findViewById(R.id.hints);
        hint.setText("Wow, you suck. It was " + random_number + ". Another number has been randomly selected");
        random_number = get_random_number();
    }

    public int get_random_number () {
        return new Random().nextInt(1001 - 1) + 1;
    }

    public boolean is_int (String str){
        if (str.matches("^-?\\d+$")) return true;
        return false;
    }
}
