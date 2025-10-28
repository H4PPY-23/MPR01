package com.example.lab01;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World!");
        Pracownicy pracownicy = new Pracownicy();
        pracownicy.dodawaniePracownik(new Pracownik("Janusz","Kowalski", "abcd@debco", "DebCo", Stanowisko.MANAGER));
        pracownicy.dodawaniePracownik(new Pracownik("Janusz", "Mordka", "abcd@debco", "DebCo", Stanowisko.PREZES));
        pracownicy.dodawaniePracownik(new Pracownik("Janusz", "Mordka", "abcd@firma", "firma", Stanowisko.PREZES));
        System.out.println(pracownicy.liczbaNaStanowisku());
        pracownicy.wyswietlPracownicy();
        Pracownicy pracownicyDebCo = new Pracownicy(pracownicy.pracownicyWFirmie("DebCo"));
        pracownicyDebCo.wyswietlPracownicy();
        System.out.println(pracownicy.srednieWynagrodzenie());
    }
}