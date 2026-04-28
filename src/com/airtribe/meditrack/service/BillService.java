package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.interfaces.Payable;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.constants.Constants;

public class BillService implements Payable {
    private DataStore<Bill> billStore = new DataStore<>();
    private Appointment appointment;

    public BillService(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public Bill generateBill() {
        double amount = appointment.getDoctor().getConsultationFee();
        Bill bill = new Bill(IdGenerator.generateBillId(), appointment, amount, Constants.TAX_RATE);
        billStore.add(bill);
        bill.displayInfo();
        return bill;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment processed successfully!");
    }
}