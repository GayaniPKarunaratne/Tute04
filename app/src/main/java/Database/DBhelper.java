package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import Model.Users;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "userdata.db";

    public DBhelper(Context context) {
        super(context, DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_create_table = "CREATE TABLE "+ UserMaster.User.TABLE_NAME+ " (" +
                UserMaster.User._ID+ " INTEGER PRIMARY KEY, "+
                UserMaster.User.COLUMN_NAME_USERNAME+ " TEXT,"+
                UserMaster.User.Column_NAME_PASSWORD+ " TEXT);";

            db.execSQL(sql_create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(String userName, String password){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserMaster.User.COLUMN_NAME_USERNAME,userName);
        contentValues.put(UserMaster.User.Column_NAME_PASSWORD,password);

        long result = db.insert(UserMaster.User.TABLE_NAME,null,contentValues);

        if (result > 0){
            //succes msg
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Users> readAllInfor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {UserMaster.User._ID,UserMaster.User.COLUMN_NAME_USERNAME,UserMaster.User.Column_NAME_PASSWORD};

        String sortOrder = UserMaster.User.COLUMN_NAME_USERNAME;

        Cursor values = db.query(UserMaster.User.TABLE_NAME,projection,null,null,null,null,sortOrder);

       ArrayList<Users> users = new ArrayList<Users>();

        while (values.moveToNext()){
            String userName = values.getString(values.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_USERNAME));
            String password = values.getString(values.getColumnIndexOrThrow(UserMaster.User.Column_NAME_PASSWORD));
            users.add( new Users(userName , password) );

        }
        return users;
    }


    public void delete(String username){
        SQLiteDatabase db = getReadableDatabase();
        String Selection = UserMaster.User.COLUMN_NAME_USERNAME + "LIKE ?";

    }
}










