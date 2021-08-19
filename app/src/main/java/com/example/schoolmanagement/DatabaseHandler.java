package com.example.schoolmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentsManager";
    private static final String TABLE_STUDENTS = "students";
    private static final String KEY_REG_NO = "reg_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_BRANCH = "branch";
    private static final String KEY_MARKS = "marks";
    private static final String KEY_PERCENTAGE = "percentage";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_REG_NO + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_BRANCH + " TEXT," + KEY_MARKS + " INTEGER," + KEY_PERCENTAGE + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_REG_NO,student.getRegNo());
        values.put(KEY_NAME, student.getName());
        values.put(KEY_BRANCH, student.getBranch());
        values.put(KEY_MARKS, student.getMarks());
        values.put(KEY_PERCENTAGE, student.getPercentage());

        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }

    Student getStudent(String regNo) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENTS, new String[] { KEY_REG_NO,
                        KEY_NAME, KEY_BRANCH, KEY_MARKS, KEY_PERCENTAGE }, KEY_REG_NO + "=?",
                new String[] { regNo }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4))
        );
        return student;
    }
}
