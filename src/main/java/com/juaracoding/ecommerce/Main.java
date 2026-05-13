package com.juaracoding.ecommerce;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products("Laptop", 15_000_000));
        products.add(new Products("Smartphone", 5_000_000));
        products.add(new Products("Headphones", 2_000_000));

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== MENU PRODUK ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Edit Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Tambah ke Keranjang");
            System.out.println("7. Tampilkan Keranjang");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String name = scanner.next();
                    System.out.print("Masukkan harga produk: ");
                    double price = scanner.nextDouble();
                    break;
                case 2:
                    System.out.println("\nDaftar Produk:");
                    for (Products p : products) {
                        System.out.println("- " + p.getName() + " : Rp " + String.format("%.0f", p.getPrice()));
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nama produk yang ingin diedit: ");
                    String editName = scanner.next();
                    boolean foundEdit = false;
                    for (Products p : products) {
                        if (p.getName().equalsIgnoreCase(editName)) {
                            System.out.print("Masukkan nama baru: ");
                            String newName = scanner.next();
                            System.out.print("Masukkan harga baru: ");
                            double newPrice = scanner.nextDouble();
                            p.setName(newName);
                            p.setPrice(newPrice);
                            foundEdit = true;
                            System.out.println("Produk berhasil diedit.");
                            break;
                        }
                    }
                    if (!foundEdit) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama produk yang ingin dihapus: ");
                    String deleteName = scanner.next();
                    boolean foundDelete = false;
                    for (Products p : products) {
                        if (p.getName().equalsIgnoreCase(deleteName)) {
                            products.remove(p);
                            foundDelete = true;
                            System.out.println("Produk berhasil dihapus.");
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan nama produk yang ingin dicari: ");
                    String searchName = scanner.next();
                    boolean foundSearch = false;
                    for (Products p : products) {
                        if (p.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Produk ditemukan: " + p.getName() + " : Rp " + String.format("%.0f", p.getPrice()));
                            foundSearch = true;
                            break;
                        }
                    }
                    if (!foundSearch) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan nama produk yang ingin dimasukkan ke keranjang: ");
                    String cartName = scanner.next();
                    boolean foundCart = false;
                    for (Products p : products) {
                        if (p.getName().equalsIgnoreCase(cartName)) {
                            cart.addProduct(p);
                            System.out.println("Produk berhasil ditambahkan ke keranjang.");
                            foundCart = true;
                            break;
                        }
                    }
                    if (!foundCart) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 7:
                    System.out.println("\nIsi Keranjang:");
                    if (cart.isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        for (Products p : cart.getItems()) {
                            System.out.println("- " + p.getName() + " : Rp " + String.format("%.0f", p.getPrice()));
                        }
                    }
                    break;
                case 8:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    break;
            }
        } while (pilihan != 8);
        scanner.close();
    }
}
