package pl.retrix.smartfarm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class LacznyPlon {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer idPola;

    @NotNull
    private Float lacznaPow;

    @NotNull
    private String typNawozu;

    @NotNull
    private Float iloscNawozu;

    @NotNull
    private Integer typUprawy;

    private Float zebranyPlon;

    public Integer getIdPola() {
        return idPola;
    }

    public LacznyPlon() {
    }

    public void setIdPola(Integer idPola) {
        this.idPola = idPola;
    }

    public Float getLacznaPow() {
        return lacznaPow;
    }

    public void setLacznaPow(Float lacznaPow) {
        this.lacznaPow = lacznaPow;
    }

    public String getTypNawozu() {
        return typNawozu;
    }

    public void setTypNawozu(String typNawozu) {
        this.typNawozu = typNawozu;
    }

    public Float getIloscNawozu() {
        return iloscNawozu;
    }

    public void setIloscNawozu(Float iloscNawozu) {
        this.iloscNawozu = iloscNawozu;
    }

    public Integer getTypUprawy() {
        return typUprawy;
    }

    public void setTypUprawy(Integer typUprawy) {
        this.typUprawy = typUprawy;
    }

    public Float getZebranyPlon() {
        return zebranyPlon;
    }

    public void setZebranyPlon(Float zebranyPlon) {
        this.zebranyPlon = zebranyPlon;
    }
}
