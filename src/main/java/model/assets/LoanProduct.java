package model.assets;

public class LoanProduct {
    private String loanProductId;
    private String loanProductName;
    private boolean assetBased;
    private String loanSecurityType;
    private double minTenure;
    private double  minLoanAmount;
    private double maxLoanAmount;
    private double roi;
    private int ltv;

    public String getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(String loanProductId) {
        this.loanProductId = loanProductId;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public boolean isAssetBased() {
        return assetBased;
    }

    public void setAssetBased(boolean assetBased) {
        this.assetBased = assetBased;
    }

    public String getLoanSecurityType() {
        return loanSecurityType;
    }

    public void setLoanSecurityType(String loanSecurityType) {
        this.loanSecurityType = loanSecurityType;
    }

    public double getMinTenure() {
        return minTenure;
    }

    public void setMinTenure(double minTenure) {
        this.minTenure = minTenure;
    }

    public double getMinLoanAmount() {
        return minLoanAmount;
    }

    public void setMinLoanAmount(double minLoanAmount) {
        this.minLoanAmount = minLoanAmount;
    }

    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public int getLtv() {
        return ltv;
    }

    public void setLtv(int ltv) {
        this.ltv = ltv;
    }

    public  int LTVCalculationAsPerCollateralType()
    {
        return 0;
    }
}
