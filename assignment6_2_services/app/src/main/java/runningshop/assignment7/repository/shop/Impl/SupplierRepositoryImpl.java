package runningshop.assignment7.repository.shop.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import runningshop.assignment7.conf.databases.DBConstants;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.SupplierRepository;

/**
 * Created by Siraaj on 04/22/2016.
 */
public class SupplierRepositoryImpl extends SQLiteOpenHelper implements SupplierRepository {

    public static final String TABLE_NAME ="supplier";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME="supplierName";
    public static final String COLUMN_POSTALCODE="psotalCode";
    public static final String COLUMN_STREETNAME="streetName";
    public static final String COLUMN_SUBURB="suburb";

    //Create DATABASE
    private static final String CREATE_DATABASE =" CREATE TABLE "
            +TABLE_NAME + "("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_NAME+" TEXT NOT NULL, "
            +COLUMN_POSTALCODE+" TEXT NOT NULL, "
            +COLUMN_STREETNAME+" TEXT NOT NULL, "
            +COLUMN_SUBURB+" TEXT NOT NULL );";


    public SupplierRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open(){
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }
    @Override
    public Supplier findByid(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_POSTALCODE,
                        COLUMN_STREETNAME,
                        COLUMN_SUBURB},
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final AddressVO address = new AddressVO.AddressBuilder()
                    .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                    .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                    .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                    .build();

            final Supplier supplier = new Supplier.BuilderSupplier()
                    .supplierID(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .supplierName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .supplierAddress(address)
                    .build();
            return supplier;
        }
        else {
            return null;
        }
    }

    @Override
    public Supplier save(Supplier entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,entity.getSupplierID());
        values.put(COLUMN_NAME,entity.getSupplierName());
        values.put(COLUMN_POSTALCODE,entity.getPostalCode());
        values.put(COLUMN_STREETNAME,entity.getStreetName());
        values.put(COLUMN_SUBURB,entity.getSuburb());
        long id = db.insertOrThrow(TABLE_NAME,null,values);

        Supplier insertedEntity = new Supplier.BuilderSupplier()
                .copy(entity)
                .supplierID(new Long(id))
                .build();

        return insertedEntity;
    }

    @Override
    public Supplier update(Supplier entity) {
        open();
        ContentValues values = new ContentValues();
       // values.put(COLUMN_ID, entity.getSupplierID());
        values.put(COLUMN_NAME,entity.getSupplierName());
        values.put(COLUMN_POSTALCODE,entity.getPostalCode());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_SUBURB,entity.getSuburb());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getSupplierID())}
        );
        return entity;
    }

    @Override
    public Supplier delete(Supplier entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID+" = ?",
                new String[]{String.valueOf(entity.getSupplierID())});
        return entity;
    }

    @Override
    public Set<Supplier> findAll() throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Supplier>suppliers = new HashSet<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final AddressVO address = new AddressVO.AddressBuilder()
                        .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                        .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                        .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                        .build();

                final Supplier supplier = new Supplier.BuilderSupplier()
                        .supplierID(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .supplierName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .supplierAddress(address)
                        .build();
                suppliers.add(supplier);
            }while (cursor.moveToNext());
        }
        return suppliers;
    }

    @Override
    public int deleteAll() {
        open();
        int deltedRows = db.delete(TABLE_NAME,null,null);
        //close();
        return deltedRows;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
