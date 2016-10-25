package com.example.android.miwok;

/**
 * Created by w.jaczewska on 2016-10-10.
 * each word associated with the texts and images
 */

public class Word {

     private String mdefaultTranslation;
     private String mmiwokTranslation;
     private int msoundID;
     private int mresourceID = NO_IMAGE_PROVIDED;
     private static final int NO_IMAGE_PROVIDED =-1;


    public Word(String defaultTranlsation, String miwokTranslation, int soundID){
        mdefaultTranslation = defaultTranlsation;
        mmiwokTranslation = miwokTranslation;
        msoundID = soundID;

    }

    public Word(String defaultTranlsation, String miwokTranslation, int resourceID, int soundID){
        mdefaultTranslation = defaultTranlsation;
        mmiwokTranslation = miwokTranslation;
        mresourceID = resourceID;
        msoundID = soundID;

    }

    public String getMiwokWord(){
        return mmiwokTranslation;
    }

    public String getDefaultWord (){
        return mdefaultTranslation;
    }

    public int getImageResourceId() { return mresourceID;}

    public int getSoundId() {return msoundID;}

    public boolean hasImage() {
        return mresourceID!= NO_IMAGE_PROVIDED;

    }

    @Override
    public String toString() {
        return "Word{" +
                "mdefaultTranslation='" + mdefaultTranslation + '\'' +
                ", mmiwokTranslation='" + mmiwokTranslation + '\'' +
                ", msoundID=" + msoundID +
                ", mresourceID=" + mresourceID +
                '}';
    }
}
