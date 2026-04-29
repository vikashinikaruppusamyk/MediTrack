package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.interfaces.Payable;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.constants.Constants;

/**
 * Service class for managing billing operations.
 * Implements Payable to generate and process bills.
 */
public class BillService implements Payable {
    private DataStore<Bill> billStore = new DataStore<>();
    private Appointment appointment;

    /**
     * Creates a BillService for the given appointment.
     * @param appointment the appointment to bill
     */
    public BillService(Appointment appointment) {
        this.appointment = appointment;
    }

    /**
     * Generates a bill based on the doctor's consultation fee and tax rate.
     * @return the generated Bill object
     */
    @Override
    public Bill generateBill() {
        double amount = appointment.getDoctor().getConsultationFee();
        Bill bill = new Bill(IdGenerator.generateBillId(), appointment, amount, Constants.TAX_RATE);
        billStore.add(bill);
        bill.displayInfo();
        return bill;
    }

    /**
     * Processes payment for the current appointment's bill.
     */
    @Override
    public void processPayment() {
        System.out.println("Payment processed successfully!");
    }
}