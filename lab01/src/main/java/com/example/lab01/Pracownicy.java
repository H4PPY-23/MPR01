package com.example.lab01;

import java.util.*;
import java.util.stream.Collectors;

public class Pracownicy {
    private List<Pracownik> pracownicy;
    public Pracownicy() {
        this.pracownicy = new ArrayList<>();
    }
    public Pracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
    //dodawanie
    public void dodawaniePracownik(Pracownik pracownik) {
        if(emailIstnieje(pracownik.getAdresEmail())){
            System.out.println("Błąd dodawania: Email już istnieje");
        }else{
            this.pracownicy.add(pracownik);
        }
    }

    private boolean emailIstnieje(String email) {
        for (Pracownik pracownik : pracownicy) {
            if(pracownik.getAdresEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    //wyswietlanie
    public void wyswietlPracownicy(){
        for(Pracownik pracownik: this.pracownicy){
            System.out.print(pracownik.getImie());
            System.out.print(", ");
            System.out.print(pracownik.getNazwisko());
            System.out.print(", ");
            System.out.print(pracownik.getAdresEmail());
            System.out.print(", ");
            System.out.print(pracownik.getNazwaFirmy());
            System.out.print(", ");
            System.out.print(pracownik.getStanowisko());
            System.out.print(", ");
            System.out.print(pracownik.getWynagrodzenie());
            System.out.print("\n");
        }
    }
    //wyszukiwanie
    public List<Pracownik> pracownicyWFirmie(String firma) {
        List<Pracownik> pracownicyWFirmie = new ArrayList<>();
        for(Pracownik pracownik: this.pracownicy){
            if(pracownik.getNazwaFirmy().equals(firma)) {
                pracownicyWFirmie.add(pracownik);
            }
        }
        return pracownicyWFirmie;
    }

    //ortowanie alfabetyczne po nazwisku
    public List<Pracownik> posortowaniPoNazwisku() {
        return pracownicy.stream()
                .sorted(Comparator.comparing(Pracownik::getNazwisko)
                        .thenComparing(Pracownik::getImie))
                .collect(Collectors.toList());
    }

    // Grupowanie po stanowisku
    public Map<Stanowisko, List<Pracownik>> grupujPoStanowisku() {
        return pracownicy.stream()
                .collect(Collectors.groupingBy(Pracownik::getStanowisko));
    }

    //Zliczanie pracowników na stanowiskach
    public Map<Stanowisko, Long> liczbaNaStanowisku() {
        return pracownicy.stream()
                .collect(Collectors.groupingBy(Pracownik::getStanowisko, Collectors.counting()));
    }

    //Średnie wynagrodzenie
    public double srednieWynagrodzenie() {
        return pracownicy.stream()
                .mapToInt(Pracownik::getWynagrodzenie)
                .average()
                .orElse(0);
    }

    //Pracownik z najwyższym wynagrodzeniem
    public Optional<Pracownik> najlepiejOplacany() {
        return pracownicy.stream()
                .max(Comparator.comparingInt(Pracownik::getWynagrodzenie));
    }
}
