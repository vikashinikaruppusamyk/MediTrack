package com.airtribe.meditrack.entity;

public class Bill {
    private String billId;
    private Appointment appointment;
    private double amount;
    private double tax;
    private double totalAmount;

    public Bill(String billId, Appointment appointment, double amount, double tax) {
        this.billId = billId;
        this.appointment = appointment;
        this.amount = amount;
        this.tax = tax;
        this.totalAmount = amount + (amount * tax / 100);
    }

    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }

    public Appointment getAppointment() { return appointment; }
    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}