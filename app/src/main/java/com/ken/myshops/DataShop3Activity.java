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

public class DataShop3Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    private EditText it3,ct3,barber13,barber23,barber33,rowId3;
    private Button btnAddData3,btnViewData3,btnDel3;
    String itHolder, ctHolder,barbar1Holder,barbar2Holder,barber3Holder;
    Boolean EditTextEmptyHold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_shop3);
        myDb = new DataBaseHelper(this);

        it3 = (EditText)findViewById(R.id.T_issued3);
        ct3 = (EditText) findViewById(R.id.Tcollected3);
        barber13=(EditText) findViewById(R.id.Barber1Amount3);
        barber23=(EditText) findViewById(R.id.Barber2amount3);
        barber33 = (EditText) findViewById(R.id.Barber3Amount3);
        rowId3=(EditText) findViewById(R.id.editTextId3);

        btnAddData3 = (Button) findViewById(R.id.data3);
        btnViewData3=(Button) findViewById(R.id.view3);
        btnDel3=(Button)findViewById(R.id.btnDelete3);

        AddData3();
        ViewData3();
        DeleteData3();

    }
    public void DeleteData3(){
        btnDel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData3(rowId3.getText().toString());
                EmptyEditTextAfterDataInsert();
                if(deleteRows>0)
                    Toast.makeText(DataShop3Activity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DataShop3Activity.this, "Data Not found", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void AddData3(){
        btnAddData3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextStatus();
                if(EditTextEmptyHold == true) {
                    boolean isInserted3 = myDb.insertData3(it3.getText().toString(), ct3.getText().toString(),
                            barber13.getText().toString(), barber23.getText().toString(), barber33.getText().toString());
                    EmptyEditTextAfterDataInsert();
                    if (isInserted3 = true)
                        Toast.makeText(DataShop3Activity.this, "Data Shop 3 is inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DataShop3Activity.this, "Data shop 3 NOT inserted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(DataShop3Activity.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void EmptyEditTextAfterDataInsert() {
        it3.getText().clear();
        ct3.getText().clear();
        barber13.getText().clear();
        barber23.getText().clear();
        barber33.getText().clear();
        rowId3.getText().clear();

    }

    private void CheckEditTextStatus() {
        itHolder = it3.getText().toString() ;
        ctHolder = ct3.getText().toString();
        barbar1Holder= barber13.getText().toString();
        barbar2Holder= barber23.getText().toString();
        barber3Holder= barber33.getText().toString();

        if(TextUtils.isEmpty(itHolder) || TextUtils.isEmpty(ctHolder) || TextUtils.isEmpty(barbar1Holder)|| TextUtils.isEmpty(barbar2Holder)|| TextUtils.isEmpty(barber3Holder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void ViewData3(){
        btnViewData3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= myDb.getAllData3();

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
                showMessage("SHOP3DATA",buffer.toString());

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
