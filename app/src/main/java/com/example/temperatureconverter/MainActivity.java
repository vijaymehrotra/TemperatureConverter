package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputTemp;
    TextView resF , resK;
    Button button;
    float t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTemp = findViewById(R.id.inputTemp);
        button = findViewById(R.id.button);
        resF = findViewById(R.id.resF);
        resK = findViewById(R.id.resK);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputTemp.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Enter the temperature", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    t = Float.parseFloat(inputTemp.getText() + "");
                }catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Enter a valid Temperature", Toast.LENGTH_SHORT).show();
                    inputTemp.setText("");
                    return;
                }
                double tempInF , tempInK;
                tempInF = (t * 1.8) + 32;
                tempInK = t + 273.0;

                resF.setText(tempInF + "");
                resK.setText(tempInK + "");
            }
        });
    }
}