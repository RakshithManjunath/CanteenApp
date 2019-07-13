package myapp.dell.example.android.bmscecanteenapp;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    public static ArrayList<Model> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnnext;
    private String[] orderList = new String[]{"Veg Fried Rice:", "Egg Fried Rice:", "Mushroom Fried Rice:", "Panneer Fried Rice:", "Schezwan Fried Rice:"};
    private String[] priceList = new String[]{"35", "40", "45", "45", "50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btnnext = (Button) findViewById(R.id.next);


        modelArrayList = getModel();
        customAdapter = new CustomAdapter(this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Model> getModel() {
        ArrayList<Model> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            Model model = new Model();
            model.setNumber(0);
            model.setTotal(0);
            model.setOrder(orderList[i]);
            model.setPrices(priceList[i]);
            list.add(model);
        }
        return list;
    }
}
