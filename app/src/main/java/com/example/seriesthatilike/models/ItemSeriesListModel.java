package com.example.seriesthatilike.models;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class ItemSeriesListModel{
    private String seriesName;
    private String seriesDate;
    private String seriesPlatform;
    private int intEpiNum;
    private int intSeasonNum;
    private CheckBox seriesWatch;
    private ImageButton seriesAddEp;

    public ItemSeriesListModel(String seriesName, String seriesDate, String seriesPlatform, int intEpiNum, int intSeasonNum, CheckBox seriesWatch, ImageButton seriesAddEp) {
        this.seriesName = seriesName;
        this.seriesDate = seriesDate;
        this.seriesPlatform = seriesPlatform;
        this.intEpiNum = intEpiNum;
        this.intSeasonNum = intSeasonNum;
        this.seriesWatch = seriesWatch;
        this.seriesAddEp = seriesAddEp;
    }

    public String getSeriesPlatform() {
        return seriesPlatform;
    }

    public void setSeriesPlatform(String seriesPlatform) {
        this.seriesPlatform = seriesPlatform;
    }

    public CheckBox getSeriesWatch() {
        return seriesWatch;
    }

    public void setSeriesWatch(CheckBox seriesWatch) {
        this.seriesWatch = seriesWatch;
    }

    public ImageButton getSeriesAddEp() {
        return seriesAddEp;
    }

    public void setSeriesAddEp(ImageButton seriesAddEp) {
        this.seriesAddEp = seriesAddEp;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesDate() {
        return seriesDate;
    }

    public void setSeriesDate(String seriesDate) {
        this.seriesDate = seriesDate;
    }

    public int getIntEpiNum() {
        return intEpiNum;
    }

    public void setIntEpiNum(int intEpiNum) {
        this.intEpiNum = intEpiNum;
    }

    public int getIntSeasonNum() {
        return intSeasonNum;
    }

    public void setIntSeasonNum(int intSeasonNum) {
        this.intSeasonNum = intSeasonNum;
    }
}