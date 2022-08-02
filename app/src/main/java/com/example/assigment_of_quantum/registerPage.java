package com.example.assigment_of_quantum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assigment_of_quantum.databinding.ActivityRegisterPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registerPage extends AppCompatActivity {
    ActivityRegisterPageBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    TextView signIn;
    Button loginTopRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        binding=ActivityRegisterPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        signIn =findViewById(R.id.signIn);
        loginTopRegister=findViewById(R.id.loginTopRegister);
        getWindow().setStatusBarColor(ContextCompat.getColor(registerPage.this,R.color.red));

        auth= FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.loginBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.createUserWithEmailAndPassword(binding.emailAddressRegister.getText().toString(),
                        binding.textPasswordRegister.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            infoOfUser user = new infoOfUser(binding.textPersonName.getText().toString(),binding.emailAddressRegister.getText().toString(),
                                    binding.editTextPhone.getText().toString(),binding.textPasswordRegister.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("User").child(id).setValue(user);
                            Toast.makeText(registerPage.this, "Account create Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registerPage.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                        else{
                            Toast.makeText(registerPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(registerPage.this,loginPage.class);
                startActivity(intent);
            }
        });

        loginTopRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(registerPage.this,loginPage.class);
                startActivity(intent);
            }
        });

    }
}
