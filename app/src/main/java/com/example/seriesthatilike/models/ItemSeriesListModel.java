package com.example.seriesthatilike.models;

import java.util.Date;

public class ItemSeriesListModel{
    private String seriesName;
    private String seriesTitleDescription;
    private String seriesDescription;
    private Date seriesDate;
    private int intEpiNum;
    private int intSeasonNum;
    private String btnWatch;

    public ItemSeriesListModel(String seriesName, String seriesTitleDescription, String seriesDescription,
                               Date seriesDate, int intEpiNum, int intSeasonNum, String btnWatch) {

        this.seriesName = seriesName;
        this.seriesTitleDescription = seriesTitleDescription;
        this.seriesDescription = seriesDescription;
        this.seriesDate = seriesDate;
        this.intEpiNum = intEpiNum;
        this.intSeasonNum = intSeasonNum;
        this.btnWatch = btnWatch;
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

    public String getBtnWatch() {
        return btnWatch;
    }

    public void setBtnWatch(String btnWatch) {
        this.btnWatch = btnWatch;
    }
}