package runningshop.assignment7.repository.employee.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;
import android.util.Log;
import android.database.SQLException;

//import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import runningshop.assignment7.conf.databases.DBConstants;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;

/**
 * Created by Siraaj on 04/21/2016.
 */
public class EmployeeRepositoryImpl extends SQLiteOpenHelper implements EmployeeRepository {


    public static final String TABLE_NAME="employees";
    private SQLiteDatabase db;

    //TABLE COLUMNS
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "employeeFirstName";
    public static final String COLUMN_SURNAME = "employeeSurname";
    public static final String COLUMN_POSTALCODE= "postalCode";
    public static final String COLUMN_STREETNAME= "streetName";
    public static final String COLUMN_SUBURB = "suburb";



    //Create table
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_FIRSTNAME +" TEXT NOT NULL, "
            +COLUMN_SURNAME + " TEXT NOT NULL, "
            +COLUMN_POSTALCODE + " TEXT NOT NULL, "
            +COLUMN_STREETNAME + " TEXT NOT NULL, "
            +COLUMN_SUBURB + " TEXT NOT NULL );";


    public EmployeeRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException{
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
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

    @Override
    public Employee findByid(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FIRSTNAME,
                        COLUMN_SURNAME,
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
                    .streetName(cursor  .getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                    .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                    .build();

            final Employee employee = new Employee.EmployeeBuilder()
                    .employeeCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .address(address)
                    .build();
            return employee;
        }
        else {
            return null;
        }
    }

    @Override
    public Employee save(Employee entity) {

        open();
        ContentValues values = new ContentValues();

       //values.put(COLUMN_ID,entity.getEmpCode());
        values.put(COLUMN_FIRSTNAME,entity.getName());
        values.put(COLUMN_SURNAME,entity.getSurname());
        values.put(COLUMN_POSTALCODE, entity.getPostalCode());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_SUBURB, entity.getSuburb());


       long id = db.insertOrThrow(TABLE_NAME,null,values);

        Employee insertedEntity = new Employee.EmployeeBuilder()
                .copy(entity)
                .employeeCode(id)
                .build();

        return insertedEntity;
    }

    @Override
    public Employee update(Employee entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,entity.getEmpCode());
        values.put(COLUMN_FIRSTNAME,entity.getName());
        values.put(COLUMN_SURNAME,entity.getSurname());
        values.put(COLUMN_POSTALCODE,entity.getPostalCode());
        values.put(COLUMN_STREETNAME,entity.getStreetName());
        values.put(COLUMN_SUBURB, entity.getSuburb());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(entity.getEmpCode())}
        );

        return entity;
    }

    @Override
    public Employee delete(Employee entity)
    {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(entity.getEmpCode())});
        return entity;
    }

    @Override
    public Set<Employee> findAll() throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Employee>employees = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final AddressVO address = new AddressVO.AddressBuilder()
                        .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                        .streetName(cursor  .getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                        .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                        .build();

                final Employee employee = new Employee.EmployeeBuilder()
                        .employeeCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .address(address)
                        .build();
                employees.add(employee);
            }while(cursor.moveToNext());
        }
        return employees;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
       // close();
        return rowsDeleted;
    }
}
