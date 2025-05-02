package TugasPraktikum8;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class KoperasiApp {
    private static final String[] PRODUK = {
        "Beras", "Minyak Goreng", "Sabun", "Gula", "Telur", "Kopi", 
        "Teh", "Susu", "Mie Instan", "Pasta Gigi"
    };

    private static final int[] HARGA = {
        12000, 15000, 5000, 10000, 2000, 7000, 
        3000, 10000, 2500, 15000
    };

    public static void main(String[] args) {
        Scanner owd = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));

        System.out.println("====== Daftar Barang di Koperasi ======");
        for (int i = 0; i < PRODUK.length; i++) {
            System.out.printf("%d. %s - Rp%s\n", (i + 1), PRODUK[i], nf.format(HARGA[i]));
        }

        System.out.println("\n===== Input Data Karyawan =====");
        System.out.print("4 digit nomor registrasi karyawan: ");
        int regNum = owd.nextInt();
        owd.nextLine();

        System.out.print("Nama karyawan: ");
        String name = owd.nextLine();

        System.out.print("Gaji bulanan: ");
        int salary = owd.nextInt();

        System.out.print("Jumlah barang belanjaan: ");
        int jumlahBelanja = owd.nextInt();

        Invoice[] invoices = new Invoice[jumlahBelanja];

        for (int i = 0; i < jumlahBelanja; i++) {
            System.out.println("\n== Barang ke-" + (i + 1) + " ==");
            System.out.print("Pilih nomor barang (1-" + PRODUK.length + "): ");
            int pilih = owd.nextInt();
            while (pilih < 1 || pilih > PRODUK.length) {
                System.out.print("Pilihan tidak valid. Coba lagi: ");
                pilih = owd.nextInt();
            }

            String namaProduk = PRODUK[pilih - 1];
            int hargaProduk = HARGA[pilih - 1];

            System.out.print("Jumlah: ");
            int qty = owd.nextInt();

            invoices[i] = new Invoice(namaProduk, qty, hargaProduk);
        }

        Employee emp = new Employee(regNum, name, salary, invoices);
        emp.printEmployeeInfo();

        owd.close();
    }
}
