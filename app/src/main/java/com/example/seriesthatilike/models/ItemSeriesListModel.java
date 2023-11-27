package com.example.seriesthatilike.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ItemSeriesListModel{
    private Uri uriSeries;
    private Uri uriPlatform;
    private String seriesName;
    private String seriesTitleDescription;
    private String seriesDescription;
    private Date seriesDate;
    private int intEpiNum;
    private int intSeasonNum;
    private Uri btnWatch;

    public ItemSeriesListModel(Uri uriSeries, Uri uriPlatform,
                               String seriesName, String seriesTitleDescription, String seriesDescription,
                               Date seriesDate, int intEpiNum, int intSeasonNum, Uri btnWatch) {

        this.uriSeries = uriSeries;
        this.uriPlatform = uriPlatform;
        this.seriesName = seriesName;
        this.seriesTitleDescription = seriesTitleDescription;
        this.seriesDescription = seriesDescription;
        this.seriesDate = seriesDate;
        this.intEpiNum = intEpiNum;
        this.intSeasonNum = intSeasonNum;
        this.btnWatch = btnWatch;
    }

    public Uri getUriSeries() {
        return uriSeries;
    }

    public void setUriSeries(Uri uriSeries) {
        this.uriSeries = uriSeries;
    }

    public Uri getUriPlatform() {
        return uriPlatform;
    }

    public void setUriPlatform(Uri uriPlatform) {
        this.uriPlatform = uriPlatform;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesTitleDescription() {
        return seriesTitleDescription;
    }

    public void setSeriesTitleDescription(String seriesTitleDescription) {
        this.seriesTitleDescription = seriesTitleDescription;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public Date getSeriesDate() {
        return seriesDate;
    }

    public void setSeriesDate(Date seriesDate) {
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

    public Uri getBtnWatch() {
        return btnWatch;
    }

    public void setBtnWatch(Uri btnWatch) {
        this.btnWatch = btnWatch;
    }
}