package com.indian.states.capitals.indianstates;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private Button join;
    private Button more;
    private EditText user;
    private EditText pass;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private String username,password;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.login_id);
        join=(Button)findViewById(R.id.join_id);
        more=(Button)findViewById(R.id.more_id);
        user=(EditText)findViewById(R.id.user_id);
        pass=(EditText)findViewById(R.id.pass_id);
        progressDialog=new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();

       /* authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                    intent.putExtra("email","username");;
                    finish();

                }

            }
        };*/
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.learnmore_xml);
            }
        });


        


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginprocess();

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }*/

    private void loginprocess() {


        username=user.getText().toString().trim();
        password=pass.getText().toString().trim();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(),"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }



        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Sign In Problem",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Logging  in...",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Sign In Successful",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);


                }
            }
        });

    }

}
