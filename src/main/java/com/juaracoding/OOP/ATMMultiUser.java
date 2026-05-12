package com.juaracoding.OOP;
import java.util.Scanner;

public class ATMMultiUser {
    private static Scanner input = new Scanner(System.in);
    private static User[] users = {
        new User("Andi", "1111", 500000),
        new User("Budi", "2222", 700000),
        new User("Citra", "3333", 1000000)
    };

    public static void main(String[] args) {
        while (true) {
            User currentUser = login();
            if (currentUser != null) {
                tampilkanMenu(currentUser);
            }
        }
    }

    private static User login() {
        System.out.println("\n--- SELAMAT DATANG DI ATM ---");
        System.out.print("Masukkan PIN: ");
        String pin = input.nextLine();

        for (User u : users) {
            if (u.getPin().equals(pin)) {
                System.out.println("Login Berhasil! Halo, " + u.getNama());
                return u;
            }
        }
        System.out.println("PIN Salah. Akses Ditolak.");
        return null;
    }

    private static void tampilkanMenu(User user) {
        int pilihan;
        do {
            System.out.println("\n===== MENU ATM =====");
            System.out.println("1. Cek Saldo\n2. Tarik Tunai\n3. Setor Tunai\n4. Transfer\n5. Logout");
            System.out.print("Pilih (1-5): ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> System.out.println("Saldo Anda: Rp " + user.getSaldo());
                case 2 -> prosesTarik(user);
                case 3 -> prosesSetor(user);
                case 4 -> prosesTransfer(user);
                case 5 -> System.out.println("Terima kasih telah menggunakan layanan kami.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void prosesTarik(User user) {
        System.out.print("Jumlah Tarik: ");
        double jumlah = input.nextDouble();
        if (user.kurangiSaldo(jumlah)) {
            System.out.println("Tarik tunai berhasil. Saldo sisa: " + user.getSaldo());
        } else {
            System.out.println("Maaf, saldo tidak mencukupi.");
        }
    }

    private static void prosesSetor(User user) {
        System.out.print("Jumlah Setor: ");
        double jumlah = input.nextDouble();
        user.tambahSaldo(jumlah);
        System.out.println("Setor tunai berhasil. Saldo sekarang: " + user.getSaldo());
    }

    private static void prosesTransfer(User pengirim) {
        System.out.print("Nama Penerima: ");
        String namaTujuan = input.nextLine();
        
        User penerima = cariUser(namaTujuan);

        if (penerima == null) {
            System.out.println("User tidak ditemukan.");
        } else if (penerima == pengirim) {
            System.out.println("Tidak bisa transfer ke diri sendiri.");
        } else {
            System.out.print("Jumlah Transfer: ");
            double jumlah = input.nextDouble();
            if (pengirim.kurangiSaldo(jumlah)) {
                penerima.tambahSaldo(jumlah);
                System.out.println("Transfer ke " + penerima.getNama() + " BERHASIL!");
            } else {
                System.out.println("Saldo Anda tidak cukup.");
            }
        }
    }

    private static User cariUser(String nama) {
        for (User u : users) {
            if (u.getNama().equalsIgnoreCase(nama)) return u;
        }
        return null;
    }
}