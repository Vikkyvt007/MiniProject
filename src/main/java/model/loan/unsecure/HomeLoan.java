package model.loan.unsecure;

import enums.NatureOfProperty;
import enums.PropertyOwnership;
import enums.PropertyPurpose;
import enums.PropertyType;
import model.assets.LoanProduct;

public class HomeLoan extends LoanProduct {
    private PropertyType propertyType;
    private NatureOfProperty natureOfProperty;
    private PropertyPurpose propertyPurpose;
    private PropertyOwnership propertyOwnership;
    private double marketValue;
    private double builtUpArea;
    private double carpetArea;
    private int propertyAge;

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public NatureOfProperty getNatureOfProperty() {
        return natureOfProperty;
    }

    public void setNatureOfProperty(NatureOfProperty natureOfProperty) {
        this.natureOfProperty = natureOfProperty;
    }

    public PropertyPurpose getPropertyPurpose() {
        return propertyPurpose;
    }

    public void setPropertyPurpose(PropertyPurpose propertyPurpose) {
        this.propertyPurpose = propertyPurpose;
    }

    public PropertyOwnership getPropertyOwnership() {
        return propertyOwnership;
    }

    public void setPropertyOwnership(PropertyOwnership propertyOwnership) {
        this.propertyOwnership = propertyOwnership;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(double builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public double getCarpetArea() {
        return carpetArea;
    }

    public void setCarpetArea(double carpetArea) {
        this.carpetArea = carpetArea;
    }

    public int getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(int propertyAge) {
        this.propertyAge = propertyAge;
    }
}
