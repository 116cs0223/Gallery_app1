package com.example.user.gallery_app1;

public class images {
    public String image_url_prefix;
    public String featuredimage;

    public images(String image_url_prefix,String featuredimage)
    {
        this.image_url_prefix =image_url_prefix;
        this.featuredimage = featuredimage;

    }
    public String getImage_url_prefix()
    {
        return image_url_prefix;
    }
    public String getFeaturedimage()
    {
        return featuredimage;
    }
}
