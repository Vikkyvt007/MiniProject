package model.payment;

import enums.LoanStatus;
import enums.RepayFrequency;

import java.time.LocalDate;

public class LoanAgreement {
    private int laonAgreementId;
    private double loanAmount;
    private int tenure;
    private double roi;
    private LoanStatus loanStatus;
    private double emiPerMonth;
    private LocalDate loanDisbursalDate;
    private RepayFrequency repayFrequency;

    public int getLaonAgreementId() {
        return laonAgreementId;
    }

    public void setLaonAgreementId(int laonAgreementId) {
        this.laonAgreementId = laonAgreementId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getEmiPerMonth() {
        return emiPerMonth;
    }

    public void setEmiPerMonth(double emiPerMonth) {
        this.emiPerMonth = emiPerMonth;
    }

    public LocalDate getLoanDisbursalDate() {
        return loanDisbursalDate;
    }

    public void setLoanDisbursalDate(LocalDate loanDisbursalDate) {
        this.loanDisbursalDate = loanDisbursalDate;
    }

    public RepayFrequency getRepayFrequency() {
        return repayFrequency;
    }

    public void setRepayFrequency(RepayFrequency repayFrequency) {
        this.repayFrequency = repayFrequency;
    }
    public void calculateEMI()
    {

    }
    public void generateRepaymentSchedule()
    {

    }
    public double calculateLoanPenalty(LocalDate currentDate)
    {
        return 0;
    }
    public double calculateLoanToValueRatio()
    {
        return 0;
    }

    @Override
    public String toString() {
        return "LoanAgreement{" +
                "laonAgreementId=" + laonAgreementId +
                ", loanAmount=" + loanAmount +
                ", tenure=" + tenure +
                ", roi=" + roi +
                ", loanStatus=" + loanStatus +
                ", emiPerMonth=" + emiPerMonth +
                ", loanDisbursalDate=" + loanDisbursalDate +
                ", repayFrequency=" + repayFrequency +
                '}';
    }
}
