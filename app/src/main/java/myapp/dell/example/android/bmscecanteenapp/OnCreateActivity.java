package myapp.dell.example.android.bmscecanteenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnCreateActivity extends AppCompatActivity {
    TextView t;
    Button b;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_create);
        t=(findViewById(R.id.nav_user_mail));
        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);
    }
    public void login(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void signup(View view) {
        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
