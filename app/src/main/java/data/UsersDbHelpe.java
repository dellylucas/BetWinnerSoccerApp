package data;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import data.UsersContract.UsersEntry;

public class UsersDbHelpe extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BaseProd.db";

    public UsersDbHelpe(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE " + UsersEntry.TABLE_NAME + " ("
                    + UsersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + UsersEntry.ID + " TEXT NOT NULL,"
                    + UsersEntry.NAME + " TEXT NOT NULL,"
                    + UsersEntry.TELEPHONE + " TEXT,"
                    + UsersEntry.TYPE + " INTEGER NOT NULL,"
                    + UsersEntry.PASS + " TEXT NOT NULL,"
                    + UsersEntry.EMAIL + " TEXT NOT NULL,"
                    + "UNIQUE (" + UsersEntry.ID + "))");

/*            mockLawyer(db, new Users("Carlos Perez", "Abogado 3452534",
                    true, "Gran prof",
                    "carlos_perez.jpg"));*/
            }catch (Exception ex){
String de = "dfsf";
            }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long mockLawyer(SQLiteDatabase db, Users lawyer) {

        return db.insert(
                UsersEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());
    }

    public void consultar(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(
                UsersEntry.TABLE_NAME,  // Nombre de la tabla
                null,  // Lista de Columnas a consultar
                null,  // Columnas para la cláusula WHERE
                null,  // Valores a comparar con las columnas del WHERE
                null,  // Agrupar con GROUP BY
                null,  // Condición HAVING para GROUP BY
                null  // Cláusula ORDER BY
        );
        int hola = c.getCount();
    }

}
