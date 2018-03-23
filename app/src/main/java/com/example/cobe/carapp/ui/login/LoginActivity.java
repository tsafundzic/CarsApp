package com.example.cobe.carapp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.ValidationUtils;
import com.example.cobe.carapp.ui.main.CarsActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    EditText password;
    Button login;
    private static final String EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUI();
        setTitle(R.string.login);
    }

    private void setUI() {
        email = findViewById(R.id.etInputEmail);
        password = findViewById(R.id.etInputPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        checkValidation();
    }

    private void checkValidation() {
        if (ValidationUtils.isEmailValid(email.getText().toString())) {
            email.setError(getText(R.string.invalid_email));
        } else if (ValidationUtils.isPasswordValid(password.getText().toString())) {
            password.setError(getText(R.string.invalid_password));
        } else {
            successufulLogin();
        }
    }

    private void successufulLogin() {
        Intent intent = new Intent(this, CarsActivity.class);
        intent.putExtra(EMAIL, email.getText().toString());
        startActivity(intent);
    }
}
