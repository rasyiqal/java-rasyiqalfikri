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

    }
}