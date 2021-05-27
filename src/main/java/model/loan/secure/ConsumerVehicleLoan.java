package model.loan.secure;


import enums.AssetCategory;
import enums.AssetVariant;
import model.assets.LoanProduct;

public class ConsumerVehicleLoan extends LoanProduct {
  private  AssetCategory assetCategory;
  private   AssetVariant assetVariant;
   private String assetModel = null;
   private String manufacturer = null ;
   private int yearOfManufacture;
   private double assetCost;
   private double downPayment;

    public AssetCategory getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
    }

    public AssetVariant getAssetVariant() {
        return assetVariant;
    }

    public void setAssetVariant(AssetVariant assetVariant) {
        this.assetVariant = assetVariant;
    }

    public String getAssetModel() {
        return assetModel;
    }

    public void setAssetModel(String assetModel) {
        this.assetModel = assetModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getAssetCost() {
        return assetCost;
    }

    public void setAssetCost(double assetCost) {
        this.assetCost = assetCost;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }
}
