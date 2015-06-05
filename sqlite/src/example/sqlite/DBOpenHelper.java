package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public static SQLiteDatabase createDB(Context context) {
		DBOpenHelper openHelper = new DBOpenHelper(context);
		return openHelper.getWritableDatabase();// ��һ�ε��ô˷�����getReadableDatabase�����ᴴ�����ݿ�
	}

	public DBOpenHelper(Context context) {
		// ���ݿ��ļ�������'/appName/appPackageName/databases/'
		super(context, "test.db",// ���ݿ��ļ���
				null,// ����Ĭ���α깤��
				2// �汾�Ų���Ϊ0��Ϊ0�ᱨ��һ���ʼ�汾��1��ʼ
		);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// ���ݿⴴ��ʱ���������˷�����һ�����ڴ������
		db.execSQL("create table person(person_id integer primary key autoincrement,name verchar(20),age integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// ���ݿ�汾�Ÿ���ʱ���������˷���һ��������ݿ�汾��������ɾ���ɱ������±��޸ı��
		db.execSQL("alter table person add sex verchar(2)");
	}
}
