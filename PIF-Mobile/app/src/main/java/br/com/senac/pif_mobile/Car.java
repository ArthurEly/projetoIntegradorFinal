package br.com.senac.pif_mobile;

import android.graphics.Color;

/**
 * GETTERS E SETTERS da tabela veiculo
 */
public class Car {
    private String sign = "AAA0000";
    private String type = "Carro";
    private String manufacturer = "Lamborghini"; //relaxa, isso n vai aparecer
    private String model = "Fusca"; // Lamborghini Fusca
    private String color = "invisivel"; //quero mostrar a cor do carro
    private int year = 2077; //cyberpunk
    private String[] fruFru = {
            "dildo"
    };
    private String obs = "╚╔╩╦";
    private String userDefect = "microcefalia";
    private OS.SITUACAO situation = OS.SITUACAO.BLOQUEADO;
    //vou pular o numero da OS pq já está pego
    //vou pular o dono tb


    public Car(String sign, String type, String manufacturer, String model, String color, int year, String[] fruFru, String obs, String userDefect, OS.SITUACAO situation) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.year = year;
        this.fruFru = fruFru;
        this.obs = obs;
        this.userDefect = userDefect;
        this.situation = situation;
        this.sign = sign;
    }

    public Car(String sign, String type, String manufacturer, String model, String color, int year, String fruFru, String obs, String userDefect, OS.SITUACAO situation) {
        String[] frufruarray = fruFru.split(", ");
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.year = year;
        this.fruFru = frufruarray;
        this.obs = obs;
        this.userDefect = userDefect;
        this.situation = situation;
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getFruFru() {
        return fruFru;
    }

    public void setFruFru(String[] fruFru) {
        this.fruFru = fruFru;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getUserDefect() {
        return userDefect;
    }

    public void setUserDefect(String userDefect) {
        this.userDefect = userDefect;
    }

    public OS.SITUACAO getSituation() {
        return situation;
    }

    public void setSituation(OS.SITUACAO situation) {
        this.situation = situation;
    }

    public String getFullName() {
        return getManufacturer() + " " + getModel();
    }
}
