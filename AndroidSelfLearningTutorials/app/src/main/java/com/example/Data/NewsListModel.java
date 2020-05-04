package com.example.Data;

public class NewsListModel {

    private String ImageURL;
    private Integer ImageID;
    private String NewsHeader;
    private String NewsDescription;
    private ImageType ImageSourceType;

    public NewsListModel(String newsHeader, String newsDescription, String imageURL, ImageType imageSourceType)
    {
        this.NewsHeader = newsHeader;
        this.NewsDescription = newsDescription;
        this.ImageURL = imageURL;
        this.ImageSourceType = imageSourceType;
    }

    public String getImageURL()
    {
        return this.ImageURL;
    }
    public void setImageURL(String imageURL)
    {
        this.ImageURL = imageURL;
    }

    public Integer getDrawableImageID()
    {
        return this.ImageID;
    }
    public void setDrawableImageID(Integer imageID)
    {
        this.ImageID = imageID;
    }

    public String getNewsHeader()
    {
        return this.NewsHeader;
    }
    public void setNewsHeader(String newsHeader)
    {
        this.NewsHeader = newsHeader;
    }

    public String getNewsDescription()
    {
        return this.NewsDescription;
    }
    public void setNewsDescription(String newsDescription)
    {
        this.NewsDescription = newsDescription;
    }

    public ImageType getImageType()
    {
        return this.ImageSourceType;
    }
    public void setNewsDescription(ImageType imageSourceType)
    {
        this.ImageSourceType = imageSourceType;
    }

    public enum ImageType
    {
        FromURL, FromFileName
    }
}

enum ImageType
{
    FromURL, FromFileName
}
