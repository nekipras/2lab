package com.example.a2lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //deklaruojami pagrindiniai ui elementai
    private EditText txtInput;
    private Spinner spinnerCountType;
    private TextView txtResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ui elementu susiejimas
        txtInput = findViewById(R.id.txtInput);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        txtResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        //mygtuko "Calculate" veiksmas
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gaunamas tekstas is ivesties lauko
                String inputText = txtInput.getText().toString();

                //tikrinama, ar tekstas ivestas
                if (inputText.isEmpty()) {
                    //rodomas Toast pranesimas, jei tekstas tuscias
                    Toast.makeText(MainActivity.this, R.string.toast_empty_input, Toast.LENGTH_SHORT).show();
                } else {
                    //gaunama vartotojo pasirinkta skaiciavimo parinktis
                    String selectedOption = spinnerCountType.getSelectedItem().toString();

                    //sukuriamas Counter objektas
                    Counter counter = new Counter();
                    int result;

                    //patikrinama ka skaiciuoti
                    if (selectedOption.equals("Words")) {
                        //skaiciuojami zodziai
                        result = counter.getWordsCount(inputText);
                    } else {
                        //skaiciuojami zenklai
                        result = counter.getCharacterCount(inputText);
                    }

                    //rezultatas rodomas TextView elemente
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
    }
}
