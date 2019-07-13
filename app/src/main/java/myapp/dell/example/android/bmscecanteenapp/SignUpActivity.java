package myapp.dell.example.android.bmscecanteenapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button b;
    FirebaseAuth myFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText1=(EditText)findViewById(R.id.Name);
        editText2=(EditText)findViewById(R.id.Email);
        editText3=(EditText)findViewById(R.id.Password);
        editText4=(EditText)findViewById(R.id.RePassword);
        b=(Button)findViewById(R.id.button3);
        myFire=FirebaseAuth.getInstance();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setVisibility(View.INVISIBLE);
                final String name=editText1.getText().toString();
                String email=editText2.getText().toString();
                String password=editText3.getText().toString();
                String repass=editText4.getText().toString();

                if(name.isEmpty() ||email.isEmpty() ||password.isEmpty() ||repass.isEmpty() || !password.equals(repass)) {

                    showMessage("Please enter correct details");
                    b.setVisibility(View.VISIBLE);
                }
                else {
                    createAccount(email,name,password);
                }

            }
        });
    }
    //public void letsgo(View view) {

    //Intent intent=new Intent(this,CanteenHome.class);
    //startActivity(intent);



    //}

    private void createAccount(String email, final String name, String password) {
        myFire.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            showMessage("Account Created:)");
                            updateUserInfo(name,myFire.getCurrentUser());
                        }
                        else {
                            showMessage("Account Creation Failed(:");
                            b.setVisibility(View.VISIBLE);
                        }
                    }
                });



    }
    private void updateUserInfo(String name, FirebaseUser currentUser) {
        UserProfileChangeRequest profleUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        currentUser.updateProfile(profleUpdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            // user info updated successfully
                            showMessage("Successfully Registered");
                            updateUI();
                        }

                    }
                });
    }

    private void updateUI() {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }


    private void showMessage(String message) {
        Toast toast=Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

}

