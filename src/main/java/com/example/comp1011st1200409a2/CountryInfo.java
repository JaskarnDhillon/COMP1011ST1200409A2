package com.example.comp1011st1200409a2;

import java.util.ArrayList;

public class CountryInfo {
    private Name name;
    private String region;
    private String subregion;
    private String population;
    private String area;
    private Flags flags;
    private ArrayList<String> capital;

    public ArrayList<String> getCapital() {
        return capital;
    }

    public Name getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public Flags getFlags() {
        return flags;
    }

    public String toString(){
        return String.format(String.valueOf(name));
    }
}
