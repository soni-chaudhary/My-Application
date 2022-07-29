package com.example.assigment_of_quantum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assigment_of_quantum.databinding.ActivityLoginPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    ActivityLoginPageBinding binding;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
//        registerNow = findViewById(R.id.registerNow);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginPage.this,registerPage.class);
                startActivity(intent);
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(loginPage.this,R.color.red));
        auth=FirebaseAuth.getInstance();

        binding.loginBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signInWithEmailAndPassword(binding.textEmailAddressLogin.getText().toString(),
                        binding.textTextPasswordLogin.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(loginPage.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(loginPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginPage.this,registerPage.class);
                startActivity(intent);
            }
        });
        if(auth.getCurrentUser()!=null){
            Intent intent=new Intent(loginPage.this,MainActivity.class);
            startActivity(intent);
        }


    }
}