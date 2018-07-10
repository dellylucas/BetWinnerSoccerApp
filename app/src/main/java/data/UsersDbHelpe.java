package data;

import android.content.Context;
import android.database.Cursor;
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

            }catch (Exception ex){
                String de = "dfsf";
            }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long InsertUser( Users Use) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(
                UsersEntry.TABLE_NAME,
                null,
                Use.toContentValues());
    }

    public int CountReg(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery("select count(*) from " + UsersEntry.TABLE_NAME, null);
        cursors.moveToFirst();
        int var = cursors.getInt(0);


        return var;
       /*
        Cursor c = db.query(
                UsersEntry.TABLE_NAME,  // Nombre de la tabla
                null,  // Lista de Columnas a consultar
                null,  // Columnas para la cláusula WHERE
                null,  // Valores a comparar con las columnas del WHERE
                null,  // Agrupar con GROUP BY
                null,  // Condición HAVING para GROUP BY
                null  // Cláusula ORDER BY
        );
        int hola = c.getCount();*/
    }
        public int LogIn(String us, String pas){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = UsersEntry.NAME + " = ? AND "+ UsersEntry.PASS + " = ?";
        String selectionArgs[] = new String[]{us,pas};

        int c = db.query(
                UsersEntry.TABLE_NAME,  // Nombre de la tabla
                null,  // Lista de Columnas a consultar
                selection,  // Columnas para la cláusula WHERE
                selectionArgs,  // Valores a comparar con las columnas del WHERE
                null,  // Agrupar con GROUP BY
                null,  // Condición HAVING para GROUP BY
                null  // Cláusula ORDER BY
        ).getCount();
        return  c;

    }

}
