package com.juaracoding;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] kategori  = {"Laptop", "Smartphone", "Tablet", "Aksesori", "Smartwatch"};
        int[]    stok      = {10, 5, 8, 20, 12};
        double[] harga     = {12_000_000, 5_000_000, 4_500_000, 500_000, 3_000_000};

        System.out.println("Daftar Produk:");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println(i + ". " + kategori[i] + " | Stok: " + stok[i] + " | Harga: Rp " + (long) harga[i]);
        }
        System.out.println();

        int jumlahJenis = 0;
        while (true) {
            System.out.print("Mau beli berapa jenis produk?");
            if (sc.hasNextInt()) {
                jumlahJenis = sc.nextInt();
                sc.nextLine();
                if (jumlahJenis > 0) break;
                System.out.println("Jumlah jenis harus lebih dari 0");
            } else {
                System.out.println("Input tidak valid. Masukkan angka bulat.");
                sc.nextLine();
            }
        }

        int[] beliIndeks = new int[jumlahJenis];
        int[] beliQty    = new int[jumlahJenis];
        int   itemBerhasil = 0;
        double totalBelanja = 0;

        System.out.println();

        for (int i = 0; i < jumlahJenis; i++) {
            System.out.println("Item " + (i + 1) + ":");

            int pilihanKategori = -1;
            while (true) {
                System.out.print("Pilih kategori (0-" + (kategori.length - 1) + "): ");
                if (sc.hasNextInt()) {
                    pilihanKategori = sc.nextInt();
                    sc.nextLine();
                    if (pilihanKategori >= 0 && pilihanKategori < kategori.length) break;
                    System.out.println("  Pilihan harus antara 0 sampai " + (kategori.length - 1) + ".");
                } else {
                    System.out.println("Input tidak valid");
                    sc.nextLine();
                }
            }

            System.out.println("   " + kategori[pilihanKategori] + " | Stok tersedia: " + stok[pilihanKategori] + " | Harga: Rp " + (long) harga[pilihanKategori]);

            int jumlahBeli = 0;
            while (true) {
                System.out.print("Jumlah yang ingin dibeli: ");
                if (sc.hasNextInt()) {
                    jumlahBeli = sc.nextInt();
                    sc.nextLine();
                    if (jumlahBeli > 0) break;
                    System.out.println("Jumlah harus lebih dari 0");
                } else {
                    System.out.println("Input tidak valid");
                    sc.nextLine();
                }
            }

            if (jumlahBeli > stok[pilihanKategori]) {
                System.out.println("  Stok tidak cukup! Stok " + kategori[pilihanKategori] + " hanya tersisa " + stok[pilihanKategori] + " unit. Pembelian dibatalkan.");
            } else {
                stok[pilihanKategori] -= jumlahBeli;

                double subtotal = harga[pilihanKategori] * jumlahBeli;
                totalBelanja += subtotal;

                beliIndeks[itemBerhasil] = pilihanKategori;
                beliQty[itemBerhasil]    = jumlahBeli;
                itemBerhasil++;

                System.out.println("  Berhasil! " + kategori[pilihanKategori] + " x" + jumlahBeli + " = Rp " + (long) subtotal);
            }
            System.out.println();
        }

        if (itemBerhasil == 0) {
            System.out.println("Tidak ada item yang berhasil dibeli. Transaksi dibatalkan.");
            sc.close();
            return;
        }

        System.out.print("Status Member (Gold / Silver / Bronze / Non-Member): ");
        String member = sc.nextLine().trim().toLowerCase();

        double persen    = 0;
        String labelMember;

        switch (member) {
            case "gold":
                persen      = 0.15;
                labelMember = "Gold (15%)";
                break;
            case "silver":
                persen      = 0.10;
                labelMember = "Silver (10%)";
                break;
            case "bronze":
                persen      = 0.05;
                labelMember = "Bronze (5%)";
                break;
            default:
                persen      = 0;
                labelMember = "Non-Member (0%)";
                break;
        }

        double diskonMember  = totalBelanja * persen;
        double setelahMember = totalBelanja - diskonMember;

        double potonganVolume = 0;

        if (setelahMember > 10_000_000) {
            potonganVolume = 500_000;
        } else if (setelahMember > 5_000_000) {
            potonganVolume = 200_000;
        }

        double totalAkhir = setelahMember - potonganVolume;

        System.out.println();
        System.out.println("=== RINGKASAN PESANAN ===");
        System.out.println();

        for (int i = 0; i < itemBerhasil; i++) {
            int    idx = beliIndeks[i];
            int    qty = beliQty[i];
            double sub = harga[idx] * qty;
            System.out.println(kategori[idx] + " x" + qty + " = Rp " + (long) sub);
        }

        System.out.println();
        System.out.println("Total Belanja Awal          : Rp " + (long) totalBelanja);
        System.out.println("Diskon Member " + labelMember + "  : -Rp " + (long) diskonMember);
        System.out.println("Total Setelah Diskon Member : Rp " + (long) setelahMember);
        System.out.println("Potongan Volume             : -Rp " + (long) potonganVolume);
        System.out.println("Total Akhir yang Dibayar    : Rp " + (long) totalAkhir);

        System.out.println();
        System.out.println("Sisa Stok Akhir:");
        for (int i = 0; i < kategori.length; i++) {
            String warning = stok[i] <= 3 ? " (stok menipis)" : "";
            System.out.println(kategori[i] + ": " + stok[i] + " unit" + warning);
        }
        System.out.println();
        System.out.println("Terima kasih telah berbelanja di Java-Tech Gadget!");

        sc.close();
    }
}