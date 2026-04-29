package com.airtribe.meditrack.entity;
/**
 * Immutable summary of a bill.
 * Cannot be modified after creation — final fields, no setters.
 */
public final class BillSummary {
    private final String billId;
    private final String patientName;
    private final String doctorName;
    private final double totalAmount;
    /**
     * Creates an immutable BillSummary.
     * @param billId unique bill identifier
     * @param patientName name of the patient
     * @param doctorName name of the doctor
     * @param totalAmount total amount paid
     */
    public BillSummary(String billId, String patientName, String doctorName, double totalAmount) {
        this.billId = billId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.totalAmount = totalAmount;
    }

    public String getBillId() { return billId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public double getTotalAmount() { return totalAmount; }
}