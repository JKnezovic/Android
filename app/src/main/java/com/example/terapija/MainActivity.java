package com.example.terapija;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in_layout);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:
                        signIn();
                        break;
                    // ...
                }
            }
        });


        }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Intent  intent = new Intent(MainActivity.this, ParentActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!= null)
        {
            Intent  intent = new Intent(MainActivity.this, ParentActivity.class);
            startActivity(intent);
        }

    }
}

/*
        txtName=(EditText)findViewById(R.id.txtName);
        txtSurname=(EditText)findViewById(R.id.txtSurename);
        txtAge=(EditText)findViewById(R.id.txtAge);
        txtSex=(EditText)findViewById(R.id.txtSex);
        btnSave=(Button) findViewById(R.id.btnSave);
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Age = Integer.parseInt(txtAge.getText().toString().trim());
            Log.i("Age",txtAge.getText().toString().trim());
            Log.i("Name",txtName.getText().toString().trim());
            Log.i("Surnmae",txtSurname.getText().toString().trim());
            Log.i("Sex",txtSex.getText().toString().trim());

            member.setName(txtName.getText().toString().trim());
            member.setSex(txtSex.getText().toString().trim());
            member.setSurname(txtSurname.getText().toString().trim());
            member.setAge(Age);
            reff.push().setValue(member);
            Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_SHORT).show();

        }
    });*/