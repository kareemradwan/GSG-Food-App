package com.kareemradwan.foodapp.ui.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {


    Button btnLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLogin = findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO :
                startActivity(new Intent(LoginActivity.this , HomeActivity.class));
                finish();
            }
        });

    }
}
