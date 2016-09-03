 package runningshop.orderingSystem.repository.shop.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import runningshop.orderingSystem.conf.databases.DBConstants;
import runningshop.orderingSystem.domain.shop.Item;
import runningshop.orderingSystem.repository.shop.ItemRepository;

/**
 * Created by Siraaj on 04/22/2016.
 */
public class ItemRepositoryImpl extends SQLiteOpenHelper implements ItemRepository {

    public static final String TABLE_NAME = "items";
    private SQLiteDatabase db;


    //TABLE COLUMNS
    public static final String COLUMN_ID= "id";
    public static final String COLUMN_NAME="itemName";


    //CREATE DATABASE
    private static final String DATABASE_CREATE =" CREATE TABLE "
            +TABLE_NAME+"("
            +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_NAME+ " TEXT NOT NULL );";


    public ItemRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }


    public void open()throws SQLException{
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }

    @Override
    public Item findByid(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME},
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final Item item = new Item.ItemBuilder()
                    .itemCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .itemName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return item;
        }
        else {
            return null;
        }
    }

    @Override
    public Item save(Item entity) {
        open();
        ContentValues values = new ContentValues();
     //   values.put(COLUMN_ID,entity.getItemCode());
        values.put(COLUMN_NAME,entity.getItemName());


        long itemID = db.insertOrThrow(TABLE_NAME, null, values);

        Item insertEntity = new Item.ItemBuilder()
                .copy(entity)
                .itemCode(new Long(itemID))
                .build();

        return insertEntity;
    }

    @Override
    public Item update(Item entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,entity.getItemCode());
        values.put(COLUMN_NAME,entity.getItemName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID+" =?",
                new String[]{String.valueOf(entity.getItemCode())}
        );
        return entity;
    }

    @Override
    public Item delete(Item entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(entity.getItemCode())}
        );
        return entity;
    }

    @Override
    public Set<Item> findAll() throws java.sql.SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Item>items = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final Item item = new Item.ItemBuilder()
                        .itemCode(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .itemName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                items.add(item);
            }while(cursor.moveToNext());
        }
        return items;
    }

    @Override
    public int deleteAll() {
        open();
        int deletedRows = db.delete(TABLE_NAME,null,null);
        //close();
        return deletedRows;
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
