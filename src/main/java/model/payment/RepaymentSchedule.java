package model.payment;

import enums.EMIPaidStatus;

import java.time.LocalDate;

public class RepaymentSchedule {
    private double emiAmount;
    private LocalDate emiDueDate;
    private EMIPaidStatus status;
    private double principalComponent;
    private double interestAmount;
    private double balancePrincipalComponent;
    private double penaltyCharges;

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public LocalDate getEmiDueDate() {
        return emiDueDate;
    }

    public void setEmiDueDate(LocalDate emiDueDate) {
        this.emiDueDate = emiDueDate;
    }

    public EMIPaidStatus getStatus() {
        return status;
    }

    public void setStatus(EMIPaidStatus status) {
        this.status = status;
    }

    public double getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(double principalComponent) {
        this.principalComponent = principalComponent;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getBalancePrincipalComponent() {
        return balancePrincipalComponent;
    }

    public void setBalancePrincipalComponent(double balancePrincipalComponent) {
        this.balancePrincipalComponent = balancePrincipalComponent;
    }

    public double getPenaltyCharges() {
        return penaltyCharges;
    }

    public void setPenaltyCharges(double penaltyCharges) {
        this.penaltyCharges = penaltyCharges;
    }
}
