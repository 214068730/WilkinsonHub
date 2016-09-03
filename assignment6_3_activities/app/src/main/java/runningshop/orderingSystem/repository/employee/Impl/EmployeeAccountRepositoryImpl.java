package runningshop.orderingSystem.repository.employee.Impl;

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
import runningshop.orderingSystem.domain.account.EmployeeAccount;
import runningshop.orderingSystem.repository.employee.EmployeeAccountRepository;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccountRepositoryImpl extends SQLiteOpenHelper implements EmployeeAccountRepository {


    public static final String TABLE_NAME="emplyeesAccount";
    private SQLiteDatabase db;


    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_USERNAME + " TEXT PRIMARY KEY NOT NULL, "
            +COLUMN_PASSWORD +" TEXT NOT NULL ); ";



    public EmployeeAccountRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }


    public void open() throws android.database.SQLException {
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }


    @Override
    public EmployeeAccount findByid(String s) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD},
                COLUMN_USERNAME+" =? ",
                new String[]{String.valueOf(s)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst()){
           final EmployeeAccount employeeAccount = new EmployeeAccount.EmployeeAccountBuidlder()
                   .username(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                   .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                   .build();
            return employeeAccount;
        }
        else
        {
            return null;
        }
    }

    @Override
    public EmployeeAccount save(EmployeeAccount entity) {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME,entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());

        db.insertOrThrow(TABLE_NAME, null, values);
        EmployeeAccount insertedEntity = new EmployeeAccount.EmployeeAccountBuidlder()
                .copy(entity)
                .build();

        return insertedEntity;
    }

    @Override
    public EmployeeAccount update(EmployeeAccount entity) {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME,entity.getUsername());
        values.put(COLUMN_PASSWORD,entity.getPassword());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_USERNAME + " =? ",
                new String[]{String.valueOf(entity.getUsername())}
        );
        return entity;
    }

    @Override
    public EmployeeAccount delete(EmployeeAccount entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_USERNAME + " =? ",
                new String[]{String.valueOf(entity.getUsername())});
        return entity;
    }

    @Override
    public Set<EmployeeAccount> findAll() throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<EmployeeAccount>employees = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final EmployeeAccount employee = new EmployeeAccount.EmployeeAccountBuidlder()
                        .username(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                        .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                        .build();
                employees.add(employee);
            }while(cursor.moveToNext());
        }
        return employees;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
        // close();
        return rowsDeleted;
    }

    @Override
    public Cursor selectAll() {
        return null;
    }

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
}
