package com.example.android.miwok;

/**
 * Created by w.jaczewska on 2016-10-10.
 */

public class Word {

     private String mdefaultTranslation;
     private String mmiwokTranslation;


    public Word(String defaultTranlsation, String miwokTranslation){
        mdefaultTranslation = defaultTranlsation;
        mmiwokTranslation = miwokTranslation;

    }

    public String getMiwokWord(){
        return mmiwokTranslation;
    }

    public String getDefaultWord (){
        return mdefaultTranslation;
    }


}
