package com.example.movies_app.Model;

public class MovieItem {
    private int id;
    private String mImageUrl;
    private String mTitle;
    private String mOriginTitle;
    private  String mOverview;

    public void setId(int id) {
        this.id = id;
    }

    public void setmOriginTitle(String mOriginTitle) {
        this.mOriginTitle = mOriginTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public MovieItem(){

    }
    public MovieItem(int ID,String ImageUrl, String Title, String OriginTitle, String Overview)
    {
        mImageUrl=ImageUrl;
        mTitle=Title;
        mOriginTitle=OriginTitle;
        mOverview=Overview;
    }

    public MovieItem(String imageUrl, String title, String origin_title, String overview) {
        mImageUrl=imageUrl;
        mTitle=title;
        mOriginTitle=origin_title;
        mOverview=overview;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
    public String getmOriginTitle() {
        return mOriginTitle;
    }
    public String getmTitle() {
        return mTitle;
    }

    public int getId() {
        return id;
    }
    public String getmOverview() {
        return mOverview;
    }

}

