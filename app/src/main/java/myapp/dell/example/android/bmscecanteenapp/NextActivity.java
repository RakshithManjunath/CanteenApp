package myapp.dell.example.android.bmscecanteenapp;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//import static myapp.dell.example.android.bmscecanteenapp.AppNotification.CHANNEL_1_ID;


public class NextActivity extends AppCompatActivity {
    private TextView tv,tv1,tv2,tv3;
    Button b;
    ProgressDialog p;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    String UserId;
    FirebaseAuth.AuthStateListener mAuthListener;
    int total;
    FirebaseUser currentUser;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        b = (Button) findViewById(R.id.Confirm);
        mAuth=FirebaseAuth.getInstance();
        UserId=mAuth.getCurrentUser().getUid();
        p=new ProgressDialog(this);
        db=FirebaseFirestore.getInstance();
        notificationManager = NotificationManagerCompat.from(this);

        total=0;
        for (int i = 0; i < 5; i++) {
            int my_total = MainActivity.modelArrayList.get(i).getTotal();
            int my_quantity = MainActivity.modelArrayList.get(i).getNumber();
            String my_order=MainActivity.modelArrayList.get(i).getOrder();
            String text = tv2.getText().toString();
            String text1 = "Total price is:";
            tv.setText(mAuth.getCurrentUser().getDisplayName());
            tv1.setText(mAuth.getCurrentUser().getEmail());


            if (my_total >= 1) {
                total=total+my_total;
                tv2.setText(text + my_order + " -> " + my_quantity + " -> " + my_total + "\n");
                tv3.setText(text1 + total);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String items=tv2.getText().toString().trim();
                        String price=tv3.getText().toString().trim();
                        uploadData(items,price);
                    }
                });
            }
            if (MainActivity.modelArrayList.get(i).getNumber() < 0) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "can't choose less than 0", Toast.LENGTH_SHORT).show();
            }


        }

    }
    private void uploadData(String items,String price) {
        p.setTitle("Please Wait");
        p.show();
        String id= UUID.randomUUID().toString();
        Map<String,Object> doc=new HashMap<>();
        doc.put("UserId",id);
        doc.put("items",items);
        doc.put("price",price);
        db.collection("Orders").document(UserId).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        p.dismiss();
                        Toast.makeText(NextActivity.this,"Ordered Successfully!",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        p.dismiss();
                        Toast.makeText(NextActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }



//    private void sendOnChannel1(String items,String price,String message) {
//        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle(message)
//                .setContentText(items+"\n"+price)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .build();
//
//        notificationManager.notify(1, notification);
//    }
}
