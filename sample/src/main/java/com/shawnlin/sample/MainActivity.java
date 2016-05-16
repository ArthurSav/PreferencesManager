package com.shawnlin.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shawnlin.preferencesmanager.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INT = "int";
    private static final String KEY_OBJECT = "object";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void makeToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    class Person {

        public String name;

        public Person(String name) {
            this.name = name;
        }

    }

}
