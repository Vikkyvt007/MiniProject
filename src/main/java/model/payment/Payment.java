package model.payment;

import enums.ChequeStatus;
import enums.PaymentMode;

import java.time.LocalDate;

public class Payment {
    private String chequeNumber;
    private PaymentMode paymentMode;
    private LocalDate chequeDate;
    private LocalDate depositDate;
    private double chequeAmount;
    private String drawOn;
    private ChequeStatus status;

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }

    public double getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public String getDrawOn() {
        return drawOn;
    }

    public void setDrawOn(String drawOn) {
        this.drawOn = drawOn;
    }

    public ChequeStatus getStatus() {
        return status;
    }

    public void setStatus(ChequeStatus status) {
        this.status = status;
    }
}
