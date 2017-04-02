package com.appcrops.networksample;

/**
 * Created by mraavi on 01/04/17.
 */

public class Channel {
    private String name;
    private String id;

    protected String thumbnail_id;

    public Channel(String id, String name, String thumnailId) {
        this.id = id;
        this.name = name;
        this.thumbnail_id = thumnailId;
    }

    public void setId( String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setThumbnailId(String thumnailId) {
        this.thumbnail_id = thumnailId;
    }

    public String getThumnailId() {
        return thumbnail_id;
    }
}
