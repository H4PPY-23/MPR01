package com.example.lab01;
//Klasy modelu muszą nadpisywać metody equals()
// i hashCode() (oparte na emailu)
// oraz toString().

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String adresEmail;
    private String nazwaFirmy;
    private Stanowisko stanowisko;
    private Integer wynagrodzenie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return adresEmail.equals(pracownik.adresEmail);
    }

    @Override
    public int hashCode() {
        return adresEmail.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s), firma: %s, stanowisko: %s, wynagrodzenie: %d",
                imie, nazwisko, adresEmail, nazwaFirmy, stanowisko, wynagrodzenie);
    }


    public Pracownik(String imie, String nazwisko, String adresEmail, String nazwaFirmy, Stanowisko stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresEmail = adresEmail;
        this.nazwaFirmy = nazwaFirmy;
        this.stanowisko = stanowisko;
        this.wynagrodzenie = stanowisko.getWynagrodzenie();
    }

    //gettery
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public Integer getWynagrodzenie() {
        return wynagrodzenie;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    //settery
    public void setWynagrodzenie(Integer wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNazwaFirmy(String nazwaFirmy) {this.nazwaFirmy = nazwaFirmy;}
}