package runningshop.orderingSystem.repository.customer.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.SQLException;

//import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import runningshop.orderingSystem.conf.databases.DBConstants;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.repository.customer.CustomerRepository;

/**
 * Created by Siraaj on 04/20/2016.
 */
public class CustomerRepositoryImpl extends SQLiteOpenHelper implements CustomerRepository{

   public static final String TABLE_NAME="customer";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME="firstName";
    public static final String COLUMN_POSTAL="postalCode";
    public static final String COLUMN_STREETNAME="streetName";
    public static final String COLUMN_SUBURB="suburb";


    //create database
    private static final String DATABASE_CREATE= " CREATE TABLE "
            + TABLE_NAME +"("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + COLUMN_FIRSTNAME +" TEXT NOT NULL , "
            + COLUMN_STREETNAME +" TEXT NOT NULL, "
            + COLUMN_SUBURB +" TEXT NOT NULL, "
            + COLUMN_POSTAL +" TEXT NOT NULL );";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public CustomerRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }


    public void open()throws SQLException{
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }


    public Cursor selectAll() {

        open();
        String sql="select * from customer";
        return (db.rawQuery(sql,null));
    }

    @Override
    public Customer findByid(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FIRSTNAME,
                        COLUMN_POSTAL,
                        COLUMN_STREETNAME,
                        COLUMN_SUBURB},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(cursor.moveToNext()){
            final AddressVO address = new AddressVO.AddressBuilder()
                    .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTAL)))
                    .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                    .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                    .build();
            final Customer customer = new Customer.CustomerBuild()
                    .custCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .custName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .address(address)
                    .build();

            return  customer;
        }
        else {
            return null;
        }
    }


    @Override
    public Customer save(Customer entity) {

            open();
            ContentValues values = new ContentValues();
//            values.put(COLUMN_ID, entity.getCustomerCode());
            values.put(COLUMN_FIRSTNAME, entity.getCustName());
           // values.put(COLUMN_POSTAL, entity.getPostalCode());
            values.put(COLUMN_STREETNAME, entity.getStreetName());
            values.put(COLUMN_SUBURB, entity.getSuburb());

            long id = db.insertOrThrow(TABLE_NAME, null, values);

            Customer insertCustomer = new Customer.CustomerBuild()
                    .copy(entity)
                    .custCode(new Long(id))
                    .build();
            return insertCustomer;

    }

    @Override
    public Customer update(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getCustomerCode());
        values.put(COLUMN_FIRSTNAME, entity.getCustName());
        //values.put(COLUMN_POSTAL, entity.getPostalCode());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_SUBURB, entity.getSuburb());

        //update method
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getCustomerCode())}
        );

        return entity;
    }

    @Override
    public Customer delete(Customer entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getCustomerCode())}
        );
        return entity;
    }

    @Override
    public Set<Customer> findAll()throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Customer >customers = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{

                final AddressVO address = new AddressVO.AddressBuilder()
                        .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTAL)))
                        .streetName(cursor  .getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                        .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                        .build();

                final Customer customer = new Customer.CustomerBuild()
                        .custCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .custName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .address(address)
                        .build();
                customers.add(customer);
            }while(cursor.moveToNext());
            return customers;
        }

        return null;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
//        close();
        return rowsDeleted;
    }

}
