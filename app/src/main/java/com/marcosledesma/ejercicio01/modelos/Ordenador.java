package com.marcosledesma.ejercicio01.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Ordenador implements Parcelable {
    private String marca;
    private String modelo;
    private String procesador;
    private float pulgadas;
    private int tamanioDisco;
    private int tamanioRam;
    private boolean ssd;

    public Ordenador(String marca, String modelo, String procesador, float pulgadas, int tamanioDisco, int tamanioRam, boolean ssd) {
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.pulgadas = pulgadas;
        this.tamanioDisco = tamanioDisco;
        this.tamanioRam = tamanioRam;
        this.ssd = ssd;
    }

    public Ordenador() {
    }

    protected Ordenador(Parcel in) {
        marca = in.readString();
        modelo = in.readString();
        procesador = in.readString();
        pulgadas = in.readFloat();
        tamanioDisco = in.readInt();
        tamanioRam = in.readInt();
        ssd = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeString(modelo);
        dest.writeString(procesador);
        dest.writeFloat(pulgadas);
        dest.writeInt(tamanioDisco);
        dest.writeInt(tamanioRam);
        dest.writeByte((byte) (ssd ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ordenador> CREATOR = new Creator<Ordenador>() {
        @Override
        public Ordenador createFromParcel(Parcel in) {
            return new Ordenador(in);
        }

        @Override
        public Ordenador[] newArray(int size) {
            return new Ordenador[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getTamanioDisco() {
        return tamanioDisco;
    }

    public void setTamanioDisco(int tamanioDisco) {
        this.tamanioDisco = tamanioDisco;
    }

    public int getTamanioRam() {
        return tamanioRam;
    }

    public void setTamanioRam(int tamanioRam) {
        this.tamanioRam = tamanioRam;
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", procesador='" + procesador + '\'' +
                ", pulgadas=" + pulgadas +
                ", tamanioDisco=" + tamanioDisco +
                ", tamanioRam=" + tamanioRam +
                ", ssd=" + ssd +
                '}';
    }
}
