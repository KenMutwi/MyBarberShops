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

public class DataShop2Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText it2,ct2,barb12,barb22,barb32,rowId2;
    Button btnAddData2,btnViewData2,btnDel2;
    String itHolder, ctHolder,barbar1Holder,barbar2Holder,barber3Holder;
    Boolean EditTextEmptyHold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_shop2);
        myDb = new DataBaseHelper(this);

        it2 = (EditText)findViewById(R.id.T_issued2);
        ct2 = (EditText) findViewById(R.id.Tcollected2);
        barb12=(EditText) findViewById(R.id.Barber1Amount2);
        barb22=(EditText) findViewById(R.id.Barber2amount2);
        barb32 = (EditText) findViewById(R.id.Barber3Amount2);
        rowId2=(EditText) findViewById(R.id.EditTextId2);

        btnAddData2 = (Button) findViewById(R.id.data2);
        btnViewData2=(Button) findViewById(R.id.view2);
        btnDel2= (Button) findViewById(R.id.btnDelete2);

        AddData2();
        ViewData2();
        DeleteData2();

    }
    public void DeleteData2(){
       btnDel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData2(rowId2.getText().toString());
                EmptyEditTextAfterDataInsert();
                if(deleteRows>0)
                    Toast.makeText(DataShop2Activity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DataShop2Activity.this, "Data Not found", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void AddData2(){
        btnAddData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextStatus();
                if(EditTextEmptyHold == true) {
                    boolean isInserted2 = myDb.insertData2(it2.getText().toString(),
                            ct2.getText().toString(),
                            barb12.getText().toString(),
                            barb22.getText().toString(),
                            barb32.getText().toString()
                    );
                    EmptyEditTextAfterDataInsert();
                    if (isInserted2 = true)
                        Toast.makeText(DataShop2Activity.this, "Data Shop 2 Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DataShop2Activity.this, "Data Shop 2 NOT Inserted", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(DataShop2Activity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void EmptyEditTextAfterDataInsert() {
        it2.getText().clear();
        ct2.getText().clear();
        barb12.getText().clear();
        barb22.getText().clear();
        barb32.getText().clear();
        rowId2.getText().clear();

    }

    private void CheckEditTextStatus() {
        itHolder = it2.getText().toString() ;
        ctHolder = ct2.getText().toString();
        barbar1Holder= barb12.getText().toString();
        barbar2Holder= barb22.getText().toString();
        barber3Holder= barb32.getText().toString();

        if(TextUtils.isEmpty(itHolder) || TextUtils.isEmpty(ctHolder) || TextUtils.isEmpty(barbar1Holder)|| TextUtils.isEmpty(barbar2Holder)|| TextUtils.isEmpty(barber3Holder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void ViewData2(){
        btnViewData2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= myDb.getAllData2();

                if(res.getCount()==0){

//                    //Show message if no data
                    showMessage("Error","No Data from Shop 2");
                    return;
                }
                StringBuffer buffer= new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("TowelIssued :"+ res.getString(1)+"\n");
                    buffer.append("TowelCollected :"+ res.getString(2)+"\n");
                    buffer.append("Barber1Activity :"+ res.getString(3)+"\n");
                    buffer.append("Barber2Activity :"+ res.getString(4)+"\n");
                    buffer.append("Barber3Activity :"+ res.getString(5)+"\n\n");

                }
                //Show all data
                showMessage("SHOP2DATA",buffer.toString());

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
