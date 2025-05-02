package TugasPraktikum8;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee implements Payable {
    private final int registrationNumber;
    private final String name;
    private final int salaryPerMonth;
    private final Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    public String getName() {
        return name;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public Invoice[] getInvoices() {
        return invoices;
    }

    public int getPayableAmount() {
        int totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja;
    }

    public void printEmployeeInfo() {
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));
    
        String format = "%-22s: %s\n";
    
        System.out.println("\n===== Informasi Karyawan =====");
        System.out.printf(format, "Nama", name);
        System.out.printf(format, "Nomor Registrasi", String.format("%04d", registrationNumber));
        System.out.printf(format, "Gaji Bulanan", "Rp" + nf.format(salaryPerMonth));
    
        int totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
    
        System.out.printf(format, "Gaji Setelah Potongan", "Rp" + nf.format(getPayableAmount()));
        System.out.printf(format, "Total Belanja", "Rp" + nf.format(totalBelanja));
    
        System.out.println("----- Rincian Belanjaan -----");
        for (Payable p : invoices) {
            if (p instanceof Invoice inv) {
                System.out.println(inv.getInvoiceDetailFormatted(nf));
            }
        }
    }    
}
