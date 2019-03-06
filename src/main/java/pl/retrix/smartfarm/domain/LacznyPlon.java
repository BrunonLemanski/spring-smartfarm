package pl.retrix.smartfarm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class LacznyPlon {

    //------- ZALEŻNOŚCI ------//
    @ManyToOne
    private Plony plony;

    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer idPola;

    @NotNull
    private Float lacznaPow;

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

    public Plony getPlony() {
        return plony;
    }

    public void setPlony(Plony plony) {
        this.plony = plony;
    }
}
