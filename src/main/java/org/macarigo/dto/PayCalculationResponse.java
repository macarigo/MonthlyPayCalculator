package org.macarigo.dto;

public class PayCalculationResponse {

    private double totalPay;

    public PayCalculationResponse() {
    }

    public PayCalculationResponse(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
}
