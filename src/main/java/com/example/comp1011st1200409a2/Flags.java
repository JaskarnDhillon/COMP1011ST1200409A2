package com.example.comp1011st1200409a2;

public class Flags {
    private String png;

    /**
     * method returns a string
     * @return
     */
    public String getPng() {
        return png;
    }

    /**
     * method overrides default toString
     * to return a "png" string
     * @return
     */
    @Override
    public String toString() {
        return String.format(png);
    }
}
