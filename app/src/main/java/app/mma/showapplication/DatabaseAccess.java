package app.mma.showapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private static final String DATABASE_NAME = "quotes.db";
    private SQLiteOpenHelper openHelper;
    //    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     *
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
//        this.database =
        this.openHelper.getWritableDatabase();

    }

    /**
     * Close the database connection.
     */
    public void close() {
//        if (database != null)
        {
//            this.database.close();
            this.openHelper.getWritableDatabase().close();

        }
    }

    /**
     * Read all qtes from the database.
     *
     * @return a List of
     */
    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        String w = this.openHelper.getDatabaseName();
        String q = this.openHelper.toString();
        String e = this.openHelper.getWritableDatabase().getPath();
        long t = this.openHelper.getWritableDatabase().getPageSize();
        Log.i("cv", w);
        Log.i("v", e);
        Log.i("y", String.valueOf(t));
        Cursor cursor = openHelper.getWritableDatabase().rawQuery("SELECT  * FROM 'qes'", null);
        cursor.moveToFirst();
        // while (!cursor.isAfterLast()) {
        // list.add(cursor.getString(2));

        // cursor.moveToNext();
        String temp1 = cursor.getString(2);
//            String qusChoice = temp.substring(1,temp.length() - 1);
//        String temp1 = cursor.getString(6);
        Log.i(temp1, temp1);
//        String[] arrayList1 = temp1.split("،");
//        ArrayList<String> choiceList3 = new ArrayList<String>();
//        for (int i = 0; i < arrayList1.length; i++) {
//            if (arrayList1[i].equals("،")) {
//                int n = 0;
//            } else if (arrayList1[i].contains("اعتماد")) {
//                for (int r = 0; r < 6; r++) {
//                    i++;
//                    choiceList3.add(arrayList1[i]);
//                    Log.i("i3", String.valueOf(i));
//                }
//                i = i - 5;
//            }
//
//            }
        String[] arrayList = temp1.split("،");
       // ArrayList<String> choiceList3 = new ArrayList<String>();
        ArrayList<String> choiceList = new ArrayList<String>();
        ArrayList<String> choiceList2 = new ArrayList<String>();
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals("،")) {
                int n = 0;
            } else if (arrayList[i].contains("پشتکار")) {
                for (int r = 0; r < 6; r++) {
                    i++;
                    choiceList.add(arrayList[i]);
                    Log.i("i1", String.valueOf(i));
                }i=i-5;


            }
//            else if (arrayList[i].contains("اعتماد")) {
//                for (int r = 0; r < 5; r++) {
//                    i++;
//
//                    choiceList2.add(arrayList[i ]);
//
//                }i=i-4;
//            }
//            else
//                cursor.moveToNext();
//            if (arrayList[i].contains("نئو")) {
//                for (int r = 0; r < 6; r++) {
//                    i++;
//                    choiceList3.add(arrayList[i]);
//                    Log.i("i3", String.valueOf(i));
//                }
//                i = i - 5;
//            }
            Log.i("i2", String.valueOf(i));

//            String temp2 = cursor.getString(2);
//        String[] arrayList2 =temp2 .split("،");
//            ArrayList<String> choiceList2 = new ArrayList<String>();
//            for (int m =0; m < arrayList2.length; m++) {
//                if (arrayList2[m].equals("،"))
//                { int n = 0; }
//
            // }
        }

            cursor.close();


    if (choiceList.contains("پشتکار"))   return choiceList;
//    else    return choiceList2;
        return choiceList;
    }
}