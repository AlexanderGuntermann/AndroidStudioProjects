package com.example.alexguntermann.helloflags;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by alexguntermann on 2/26/18.
 */

public class RegionsFormat {

    private ArrayList<Drawable> flags;
    private String correctName;
    private ArrayList<String> wrongNames;


    public RegionsFormat() {
        this.correctName = "";
        this.wrongNames = new ArrayList<>();
        this.flags = new ArrayList<>();

    }

    public RegionsFormat(ArrayList<Drawable> flags, String correctName, ArrayList<String> wrongNames) {
        this.flags = flags;
        this.correctName = correctName;
        this.wrongNames = wrongNames;
    }

    public ArrayList<Drawable> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Drawable> flags) {
        this.flags = flags;
    }

    public String getCorrectName() {
        return correctName;
    }

    public void setCorrectName(String correctName) {
        this.correctName = correctName;
    }

    public ArrayList<String> getWrongNames() {
        return wrongNames;
    }

    public void setWrongNames(ArrayList<String> wrongNames) {
        this.wrongNames = wrongNames;
    }
}
