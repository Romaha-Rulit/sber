package com.sber.dz3.figures;

public enum Color {
    BLACK("черный"),
    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий"),
    YELLOW("желтый"),
    PURPLE("фиолетовый"),
    ORANGE("оранжевый");

    private final String russianName;

    Color(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
