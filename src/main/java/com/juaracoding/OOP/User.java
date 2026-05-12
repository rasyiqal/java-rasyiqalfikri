package com.juaracoding.OOP;

public class User {
    private String nama;
    private String pin;
    private double saldo;

    public User(String nama, String pin, double saldoAwal) {
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldoAwal;
    }

    public String getNama() {
        return nama;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    public boolean kurangiSaldo(double jumlah) {
        if (jumlah > 0 && saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }
}
