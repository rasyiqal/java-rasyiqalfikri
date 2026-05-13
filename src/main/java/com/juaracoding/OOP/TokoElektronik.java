package com.juaracoding.OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class TokoElektronik {

    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMENU:");
            System.out.println("1. Tambah Produk (Create)");
            System.out.println("2. Tampilkan Semua Produk (Read)");
            System.out.println("3. Ubah Nama Produk (Update)");
            System.out.println("4. Hapus Produk (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama produk baru: ");
                    String newProduct = scanner.nextLine();
                    products.add(newProduct);
                    System.out.println("Produk berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.println("\n--- Daftar Produk ---");
                    if (products.isEmpty()) {
                        System.out.println("Daftar kosong.");
                    } else {
                        for (int i = 0; i < products.size(); i++) {
                            System.out.println(i + ". " + products.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor indeks produk yang ingin diubah: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); 
                    if (updateIndex >= 0 && updateIndex < products.size()) {
                        System.out.print("Masukkan nama baru: ");
                        String updatedName = scanner.nextLine();
                        products.set(updateIndex, updatedName);
                        System.out.println("Produk berhasil diperbarui.");
                    } else {
                        System.out.println("Indeks tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nomor indeks produk yang ingin dihapus: ");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex >= 0 && deleteIndex < products.size()) {
                        products.remove(deleteIndex);
                        System.out.println("Produk berhasil dihapus.");
                    } else {
                        System.out.println("Indeks tidak ditemukan!");
                    }
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}