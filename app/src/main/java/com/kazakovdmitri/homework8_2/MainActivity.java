package com.kazakovdmitri.homework8_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text);
        final Button btn = findViewById(R.id.button);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                switch (selectedId) {
                    case R.id.radioButtonRu: {
                        switchLocale("ru");
                        break;
                    }
                    case R.id.radioButtonEn: {
                        switchLocale("en");
                        break;
                    }
                    case R.id.radioButtonFr: {
                        switchLocale("fr");
                        break;
                    }
                }
            }
        });


    }

    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
