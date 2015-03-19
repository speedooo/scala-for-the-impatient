package scala4impatient;

public class Ch05Ex09_CarInJava {
    private final String manufacturer;
    private final String modelName;
    private int modelYear = -1;
    private String licensePlate = "";

    public Ch05Ex09_CarInJava(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, int modelYear) {
        this(manufacturer, modelName);
        this.modelYear = modelYear;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, String licensePlate) {
        this(manufacturer, modelName);
        this.licensePlate = licensePlate;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this(manufacturer, modelName, modelYear);
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
