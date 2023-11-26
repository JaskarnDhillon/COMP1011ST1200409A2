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

    /**
     * returns an ArrayList<String>
     * @return
     */
    public ArrayList<String> getCapital() {
        return capital;
    }

    /**
     * returns a name object
     * @return
     */
    public Name getName() {
        return name;
    }

    /**
     * returns a string
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     * returns a string
     * @return
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     * returns a string
     * @return
     */
    public String getPopulation() {
        return population;
    }

    /**
     * returns a string
     * @return
     */
    public String getArea() {
        return area;
    }

    /**
     * returns a flag object
     * @return
     */
    public Flags getFlags() {
        return flags;
    }


    /**
     * method overrides default toString
     * to return a "name" string
     * @return
     */
    public String toString(){
        return String.format(String.valueOf(name));
    }
}
