package com.ken.myshops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyShopActivity extends AppCompatActivity {
    Button shp1,shp2,shp3,shp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shop);

        shp1= (Button)findViewById(R.id.shop1);
        shp2= (Button) findViewById(R.id.shop2);
        shp3= (Button) findViewById(R.id.shop3);
        shp4= (Button) findViewById(R.id.shop4);

        shop1Details();
        shop2Details();
        shop3Details();
        shop4Details();
    }
    public void shop1Details(){
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop1 = new Intent(MyShopActivity.this,DataShop1Activity.class);
                startActivity(shop1);
            }
        });
    }
    public void shop2Details(){
        shp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop2 = new Intent(MyShopActivity.this,DataShop2Activity.class);
                startActivity(shop2);
            }
        });
    }
    public void shop3Details(){
        shp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop3 = new Intent(MyShopActivity.this,DataShop3Activity.class);
                startActivity(shop3);
            }
        });
    }
    public void shop4Details(){
        shp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop4 = new Intent(MyShopActivity.this,DataShop4Activity.class);
                startActivity(shop4);
            }
        });
    }

}
