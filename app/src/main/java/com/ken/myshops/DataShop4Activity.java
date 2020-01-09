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

public class DataShop4Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    private EditText it4,ct4,barber14,barber24,barber34,rowId4;
    private Button btnAddData4,btnViewData4,btnDel4;
    String itHolder, ctHolder,barbar1Holder,barbar2Holder,barber3Holder;
    Boolean EditTextEmptyHold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_shop4);
        myDb = new DataBaseHelper(this);

        it4 = (EditText)findViewById(R.id.T_issued4);
        ct4 = (EditText) findViewById(R.id.Tcollected4);
        barber14=(EditText) findViewById(R.id.Barber1Amount4);
        barber24=(EditText) findViewById(R.id.Barber2amount4);
        barber34 = (EditText) findViewById(R.id.Barber3Amount4);
        rowId4=(EditText) findViewById(R.id.editTextId4);

        btnAddData4 = (Button) findViewById(R.id.data4);
        btnViewData4=(Button) findViewById(R.id.view4);
        btnDel4= (Button) findViewById(R.id.btnDelete4);

        AddData4();
        ViewData4();
        DeleteData4();
    }
    public void DeleteData4(){
        btnDel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData4(rowId4.getText().toString());
                EmptyEditTextAfterDataInsert();
                if(deleteRows>0)
                    Toast.makeText(DataShop4Activity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DataShop4Activity.this, "Data Not found", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void AddData4(){
        btnAddData4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextStatus();
                if(EditTextEmptyHold == true) {
                    boolean isInserted4 = myDb.insertData4(it4.getText().toString(),
                            ct4.getText().toString(),
                            barber14.getText().toString(),
                            barber24.getText().toString(),
                            barber34.getText().toString()
                    );
                    EmptyEditTextAfterDataInsert();
                    if (isInserted4 = true)
                        Toast.makeText(DataShop4Activity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DataShop4Activity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(DataShop4Activity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void CheckEditTextStatus() {
        itHolder = it4.getText().toString() ;
        ctHolder = ct4.getText().toString();
        barbar1Holder= barber14.getText().toString();
        barbar2Holder= barber24.getText().toString();
        barber3Holder= barber34.getText().toString();

        if(TextUtils.isEmpty(itHolder) || TextUtils.isEmpty(ctHolder) || TextUtils.isEmpty(barbar1Holder)|| TextUtils.isEmpty(barbar2Holder)|| TextUtils.isEmpty(barber3Holder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void ViewData4(){
        btnViewData4 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= myDb.getAllData4();

                if(res.getCount()==0){

//                    //Show message if no data
                    showMessage("Error","No Data from Shop 3");
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
                showMessage("SHOP4DATA",buffer.toString());

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
    private void EmptyEditTextAfterDataInsert() {
        it4.getText().clear();
        ct4.getText().clear();
        barber14.getText().clear();
        barber24.getText().clear();
        barber34.getText().clear();
        rowId4.getText().clear();
    }

    }
