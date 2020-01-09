package com.ken.myshops;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Shops.db";

    public static final String TABLE_NAME = "Shop1_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "Date_inserted";
    public static final String COL_3= "Issued_Towels";
    public static final String COL_4= " Collected_Towels";
    public static final String COL_5= "Barber_1";
    public static final String COL_6= "Barber_2";
    public static final String COL_7= "Barber_3";

    public static final String TABLE_NAME2 = "Shop2_table";
    public static final String COL_12= "ID";
    public static final String COL_22= "Date_inserted";
    public static final String COL_32= "Issued_Towels";
    public static final String COL_42= "Collected_Towels";
    public static final String COL_52= "Barber_1";
    public static final String COL_62= "Barber_2";
    public static final String COL_72= "Barber_3";

    public static final String TABLE_NAME3 = "Shop3_table";
    public static final String COL_13= "ID";
    public static final String COL_23= "Date_inserted";
    public static final String COL_33= "Issued_Towels";
    public static final String COL_43= " Collected_Towels";
    public static final String COL_53= "Barber_1";
    public static final String COL_63= "Barber_2";
    public static final String COL_73= "Barber_3";

    public static final String TABLE_NAME4 = "Shop4_table";
    public static final String COL_14= "ID";
    public static final String COL_24= "Date_inserted";
    public static final String COL_34= "Issued_Towels";
    public static final String COL_44= " Collected_Towels";
    public static final String COL_54= "Barber_1";
    public static final String COL_64= "Barber_2";
    public static final String COL_74= "Barber_3";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Date_inserted DEFAULT CURRENT_TIMESTAMP,Issued_Towels INTEGER,Collected_Towels INTEGER,Barber_1 INTEGER,Barber_2 INTEGER,Barber_3 INTEGER)");
        db.execSQL("create table " + TABLE_NAME2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Date_inserted DEFAULT CURRENT_TIMESTAMP,Issued_Towels INTEGER,Collected_Towels INTEGER,Barber_1 INTEGER,Barber_2 INTEGER,Barber_3 INTEGER)");
        db.execSQL("create table " + TABLE_NAME3 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Date_inserted DEFAULT CURRENT_TIMESTAMP,Issued_Towels INTEGER,Collected_Towels INTEGER,Barber_1 INTEGER,Barber_2 INTEGER,Barber_3 INTEGER)");
        db.execSQL("create table " + TABLE_NAME4 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Date_inserted DEFAULT CURRENT_TIMESTAMP,Issued_Towels INTEGER,Collected_Towels INTEGER,Barber_1 INTEGER,Barber_2 INTEGER,Barber_3 INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME4);

        onCreate(db);

    }

    public boolean insertData1(String itowels,String ctowels,String barber11,String barber12, String barber13 ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3,itowels);
        contentValues.put(COL_4,ctowels);
        contentValues.put(COL_5,barber11);
        contentValues.put(COL_6,barber12);
        contentValues.put(COL_7,barber13);
        long result1 = db.insert(TABLE_NAME,null ,contentValues);
        if(result1== -1)
            return false;
            else
                return  true;
    }
    public Cursor getAllData1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer deleteData1(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID= ?" ,new String[]{id});


    }

    public boolean insertData2(String itowels2,String ctowels2,String barber12,String barber22, String barber32 ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_32,itowels2);
        contentValues.put(COL_42,ctowels2);
        contentValues.put(COL_52,barber12);
        contentValues.put(COL_62,barber22);
        contentValues.put(COL_72,barber32);

        long result2 = db.insert(TABLE_NAME2,null ,contentValues);
        if(result2 == -1)
            return false;
        else
            return  true;
    }
    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }
    public Integer deleteData2(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2,"ID= ?" ,new String[]{id});


    }

    public boolean insertData3(String itowels3,String ctowels3,String barber13,String barber23, String barber33 ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values3 = new ContentValues();
        values3.put(COL_33,itowels3);
        values3.put(COL_43,ctowels3);
        values3.put(COL_54,barber13);
        values3.put(COL_64,barber23);
        values3.put(COL_74,barber33);
        long result3 = db.insert(TABLE_NAME3,null,values3);
        if(result3 == -1)
            return false;
        else
            return  true;
    }
    public Cursor getAllData3() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME3, null);
        return res;
    }
    public Integer deleteData3(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME3,"ID= ?" ,new String[]{id});


    }

    public boolean insertData4(String itowels4,String ctowels4,String barber14,String barber24, String barber34 ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values4 = new ContentValues();
        values4.put(COL_34,itowels4);
        values4.put(COL_44,ctowels4);
        values4.put(COL_54,barber14);
        values4.put(COL_64,barber24);
        values4.put(COL_74,barber34);
        long result4 = db.insert(TABLE_NAME4,null,values4);
        if(result4 == -1)
            return false;
        else
            return  true;
    }

    public Cursor getAllData4() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME4, null);
        return res;
    }
    public Integer deleteData4(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME4,"ID= ?" ,new String[]{id});


    }

}
