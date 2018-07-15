package com.example.android.dictionary_acadview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatabaseHelper {
    Context context;
    private String DB_PATH;
    SQLiteDatabase db;

    DatabaseHelper(Context context){
        this.context = context;
        createDatabase();
        createTable();
        insert();
    }

    private void createDatabase() {
        try {
            db = context.openOrCreateDatabase("dictionary", Context.MODE_PRIVATE,null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    void createTable(){
        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS DICTIONARY(WORD VARCHAR , WORD_TYPE VARCHAR , WORD_MEANING VARCHAR) ");
        }catch (Exception e){
            throw e;
        }
    }
    void insert(){
        db.execSQL("INSERT INTO DICTIONARY VALUES('Bling','Noun','Expensive, ostentatious clothing and jewelry')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Bromance','noun',' A close but non-sexual relationship between two men.')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Backward','ADVERB',' to or toward what is behind')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Balance','NOUN',' the state of having your weight spread equally so that you do not fall')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Chillax','VERB','Calm down and relax')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Capacity','NOUN','the ability to hold or contain people or things ')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Damage','VERB','physical harm that is done to something or to someone body')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Dark','NOUN','having very little or no light')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Droolworthy','adjective',' Extremely attractive or desirable.')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Gather','VERB','to bring (things or people) together into a group')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Giant','ADJECTIVE',' very large')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Jacket','NOUN','an outer covering')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Jealous','ADJECTIVE','feeling or showing an unhappy or angry desire to have what someone else has')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('La-la Land','NOUN','A fanciful state or dream world. Also, Los Angeles.')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Mail','NOUN','the system used for sending letters and packages from one person to another')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Manner','NOUN',' somewhat formal : the way that something is done or happens')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Muggle','NOUN',' A person who is not conversant with a particular activity or skill.')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Rapid','ADJECTIVE',' happening in a short amount of time : happening quickly')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Rather','ADVERB','to some degree or extent')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Screenager','Noun','A person in their teens or twenties who has an aptitude for computers and the Internet')");
        db.execSQL("INSERT INTO DICTIONARY VALUES('Woot','Adverb','(Especially in electronic communication) Used to express elation, enthusiasm, or triumph.')");

    }
    String  search(String searchStr){
        Cursor c=db.rawQuery("SELECT * FROM DICTIONARY where WORD='"+searchStr+"' ",null);
        String ans="";
        if(c!=null){
            c.moveToFirst();
        }
        if(c.moveToNext()){
            int index=c.getColumnIndex("WORD");
            String word=c.getString(index);
            if(word.equals(searchStr)){
                ans=ans+word;
                int index1=c.getColumnIndex("WORD_TYPE");
                String word_type=c.getString(index1);
                int index2=c.getColumnIndex("WORD_MEANING");
                String meaning=c.getString(index2);
                ans=ans+"\n"+word_type+"\n"+meaning;
            }
        }
        return ans;
    }
}