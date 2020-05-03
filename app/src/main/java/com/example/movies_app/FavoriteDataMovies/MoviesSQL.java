package com.example.movies_app.FavoriteDataMovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.movies_app.Model.MovieItem;

import java.util.ArrayList;

public class MoviesSQL extends SQLiteOpenHelper {
    public static final String movie_data = "movies";

    public MoviesSQL(@Nullable Context context) {

        super(context, movie_data, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table favorite_movie(id INTEGER PRIMARY KEY AUTOINCREMENT,image TEXT, title TEXT,origin_title TEXT,overview TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favorite_movie");
        onCreate(db);

    }
                                 //int favoriteId,
    public void inset_data_movie(MovieItem movieItem) {
       int favoriteId=0;
        //MovieItem movieItem=new MovieItem(favoriteId,title,image,origin_title,overview);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(HelperMovieSQL.ID, movieItem.getId());
        contentValues.put(HelperMovieSQL.ORIGINTITLE, movieItem.getmOriginTitle());
        contentValues.put(HelperMovieSQL.IMAGE,movieItem.getmImageUrl() );
        contentValues.put(HelperMovieSQL.OVERVIEW, movieItem.getmOverview());
        contentValues.put(HelperMovieSQL.TITLE, movieItem.getmTitle());

        long result = sqLiteDatabase.insert(" favorite_movie", null, contentValues);
        sqLiteDatabase.close();
        favoriteId++;

    }
    public ArrayList<MovieItem> getArrayListFavorite(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from favorite_movie",null);
        res.moveToFirst();
        while (res.isAfterLast()==false)
        {
            String id=res.getColumnName(res.getColumnIndex("id"));
            String image=res.getColumnName(1);
            String title=res.getColumnName(2);
            String origin_title=res.getColumnName(3);
            String overview=res.getColumnName(4);
            arrayList.add(id+":"+image+""+title+""+origin_title+""+overview);
            res.moveToNext();

        }
        return arrayList;
    }
    public void deletFavorite(int id)//found id ???
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

      sqLiteDatabase.delete(" favorite_movie","favoriteId"+id,null);

    }
    //stack overFlow
    public String getid(String  title) throws SQLException
    {
        SQLiteDatabase sqLiteDatabase = null;
        long recc=0;
        String rec=null;
        Cursor mCursor = sqLiteDatabase.rawQuery(
                "SELECT id  FROM  savedstoriestable WHERE title="+title , null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
            recc=mCursor.getLong(0);
            rec=String.valueOf(recc);
        }
        return rec;
    }
}