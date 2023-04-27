package com.mokslai.internetisskaiciuotuvas.model;
import jakarta.validation.constraints.Min;

import javax.persistence.*;

// Tai POJO klase sujungta su duomenu bazeje esancia lentele naudojant ORM technika
@Entity // Anotacija nurodo kad susiesime POJO klase su duomenu bazeje esancia lentele kurios pavadfinimas "skaiciai"
@Table(name = "skaiciai")
public class SkaiciusZenklas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Atitinka duomenu bazes auto increment
    @Column(name = "id")
    private int id;

    @Column(name = "sk1")
    @Min(value = 0, message = "Validacijos klaida! Skaicius negali buti neigiamas!")
    private int sk1;

    @Column(name = "sk2")
    @Min(value = 0, message = "Validacijos klaida! Skaicius negali buti neigiamas!")
    private int sk2;

    private double rezultatas;
    private String zenklas;

    // Butina tureti tuscia konstruktoriu ! Del spring framework
    public SkaiciusZenklas() {}

    public SkaiciusZenklas(int id, int sk1, int sk2, double rezultatas, String zenklas) {
        this.id = id;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.rezultatas = rezultatas;
        this.zenklas = zenklas;
    }

    // Esamu duomenu DB irasu paieskai, redagavimui, trynimui
    public SkaiciusZenklas(int sk1, int sk2, double rezultatas, String zenklas) {
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.rezultatas = rezultatas;
        this.zenklas = zenklas;
    }

    public int getId() {
        return id;
    }

    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public int getSk2() {
        return sk2;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public double getRezultatas() {
        return rezultatas;
    }

    public void setRezultatas(double rezultatas) {
        this.rezultatas = rezultatas;
    }

    public String getZenklas() {
        return zenklas;
    }

    public void setZenklas(String zenklas) {
        this.zenklas = zenklas;
    }

    @Override
    public String toString() {
        return "SkaiciusZenklas{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", rezultatas=" + rezultatas +
                ", zenklas='" + zenklas + '\'' +
                '}';
    }
}
