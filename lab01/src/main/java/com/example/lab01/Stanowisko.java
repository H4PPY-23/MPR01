package com.example.lab01;

public enum Stanowisko {
    PREZES(25000, 0), WICEPPREZES(18000, 1), MANAGER(12000, 2), PROGRAMISTA(8000,3), STAZYSTA(3000,4);

    private int wynagrodzenie, poziom;
    Stanowisko(int wynagrodzenie, int poziom) {
        this.wynagrodzenie = wynagrodzenie;
        this.poziom = poziom;
    }
    public int getWynagrodzenie() {
        return wynagrodzenie;
    }
    public int getPoziom() {
        return poziom;
    }
}
