package utils;

public class TestData {

    Double weight;
    Double height;

    public TestData(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public Double getBmi() {
        Double bmi = weight / ((height * height / 10000));
        return bmi;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
