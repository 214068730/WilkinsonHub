package runningshop.orderingSystem.repository.shop.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import runningshop.orderingSystem.conf.databases.DBConstants;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Shop;
import runningshop.orderingSystem.repository.shop.ShopRepository;

/**
 * Created by Siraaj on 04/22/2016.
 */
public class ShopRepositoryImpl extends SQLiteOpenHelper implements ShopRepository {

    public static final String TABLE_NAME="shop";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME= "shopName";
    public static final String COLUMN_POSTALCODE= "postalCode";
    public static final String COLUMN_STREETNAME ="streetName";
    public static final String COLUMN_SUBURB="suburb";

    //Create db
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME + "("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_NAME+" TEXT NOT NULL, "
            +COLUMN_POSTALCODE+" TEXT NOT NULL, "
            +COLUMN_STREETNAME+" TEXT NOT NULL, "
            +COLUMN_SUBURB+" TEXT NOT NULL );";


    public ShopRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open(){
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }

    @Override
    public Shop findByid(Long id) {
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
            final Shop shop = new Shop.BuildShop()
                    .shopID(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .shopName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .address(address)
                    .build();
            return shop;
        }
        else {
            return null;
        }
    }

    @Override
    public Shop save(Shop entity) {
        open();
        ContentValues values = new ContentValues();
     //   values.put(COLUMN_ID,entity.getShopID());
        values.put(COLUMN_NAME,entity.getShopName());
        values.put(COLUMN_POSTALCODE,entity.getPostalCode());
        values.put(COLUMN_STREETNAME,entity.getStreetName());
        values.put(COLUMN_SUBURB,entity.getSuburb());
        long id = db.insertOrThrow(TABLE_NAME,null,values);
        Shop insertedEntity = new Shop.BuildShop()
                .copy(entity)
                .shopID(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Shop update(Shop entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,entity.getShopID());
        values.put(COLUMN_NAME,entity.getShopName());
        values.put(COLUMN_POSTALCODE,entity.getPostalCode());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_SUBURB,entity.getSuburb());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID+" =? ",
                new String[]{String.valueOf(entity.getShopID())}
        );
        return entity;
    }

    @Override
    public Shop delete(Shop entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID +" =? ",
                new String[]{String.valueOf(entity.getShopID())});

        return entity;
    }

    @Override
    public Set<Shop> findAll() throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Shop>shops = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final AddressVO address = new AddressVO.AddressBuilder()
                        .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                        .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                        .suburb(cursor.getString(cursor.getColumnIndex(COLUMN_SUBURB)))
                        .build();
                final Shop shop = new Shop.BuildShop()
                        .shopID(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .shopName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .address(address)
                        .build();
                shops.add(shop);
            }while(cursor.moveToNext());

        }
        return shops;
    }

    @Override
    public int deleteAll() {
        open();
        int deletedRows = db.delete(TABLE_NAME,null,null);
     //   close();
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
