package com.ken.myshops;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataShop1Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    public EditText it1,ct1,barb11,barb12,barb13,EditTextId;
    public Button btnAddData1,btnViewData1,btnDelete1;
    String itHolder, ctHolder,barbar1Holder,barbar2Holder,barber3Holder;
    Boolean EditTextEmptyHold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_shop1);
        myDb = new DataBaseHelper(this);

        it1 = (EditText)findViewById(R.id.T_issued);
        ct1 = (EditText) findViewById(R.id.Tcollected);
        barb11=(EditText) findViewById(R.id.Barber1Amount);
        barb12=(EditText) findViewById(R.id.Barber2amount);
        barb13 = (EditText) findViewById(R.id.Barber3Amount);
        EditTextId=(EditText) findViewById(R.id.editTextid1);

        btnAddData1 = (Button) findViewById(R.id.data1);
        btnViewData1=(Button) findViewById(R.id.view1);
        btnDelete1=(Button) findViewById(R.id.btnDelete);

        AddData1();
        ViewData1();
        DeleteData1();

    }
    public void DeleteData1(){
        btnDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData1(EditTextId.getText().toString());
                EmptyEditTextAfterDataInsert();
                if(deleteRows>0)
                    Toast.makeText(DataShop1Activity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DataShop1Activity.this, "Data Not found", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void AddData1(){
        btnAddData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextStatus();
                if(EditTextEmptyHold == true) {
                    boolean isInserted1 = myDb.insertData1(it1.getText().toString(),
                            ct1.getText().toString(),
                            barb11.getText().toString(), barb12.getText().toString(),
                            barb13.getText().toString()
                    );
                    EmptyEditTextAfterDataInsert();
                    if (isInserted1 = true)
                        Toast.makeText(DataShop1Activity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                    
                    else
                        Toast.makeText(DataShop1Activity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(DataShop1Activity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void EmptyEditTextAfterDataInsert() {

        it1.getText().clear();
        ct1.getText().clear();
        barb11.getText().clear();
        barb12.getText().clear();
        barb13.getText().clear();
        EditTextId.getText().clear();


    }

    private void CheckEditTextStatus() {
        itHolder = it1.getText().toString() ;
        ctHolder = ct1.getText().toString();
        barbar1Holder= barb11.getText().toString();
        barbar2Holder= barb12.getText().toString();
        barber3Holder= barb13.getText().toString();

        if(TextUtils.isEmpty(itHolder) || TextUtils.isEmpty(ctHolder) || TextUtils.isEmpty(barbar1Holder)|| TextUtils.isEmpty(barbar2Holder)|| TextUtils.isEmpty(barber3Holder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void ViewData1(){
        btnViewData1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res1= myDb.getAllData1();

                if(res1.getCount()==0){
//                    //Show message if no data
                  showMessage("Error","No Data from Shop 1");
                   return;
                }
                StringBuffer buffer= new StringBuffer();
                while (res1.moveToNext()){
                    buffer.append("Id :"+ res1.getString(0)+"\n");
                    buffer.append("Date_inserted :"+ res1.getString(1)+"\n");
                    buffer.append("TowelIssued :"+ res1.getString(2)+"\n");
                    buffer.append("TowelCollected :"+ res1.getString(3)+"\n");
                    buffer.append("Barber1Activity :"+ res1.getString(4)+"\n");
                    buffer.append("Barber2Activity :"+ res1.getString(5)+"\n");
                    buffer.append("Barber3Activity :"+ res1.getString(6)+"\n\n");

                }
                //Show all data
                showMessage("SHOP 1 DATA",buffer.toString());

            }
        });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setTitle(Message);
        builder.show();
    }
}
