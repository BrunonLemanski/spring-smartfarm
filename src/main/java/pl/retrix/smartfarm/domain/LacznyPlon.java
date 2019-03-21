package pl.retrix.smartfarm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class LacznyPlon {

    //------- ZALEŻNOŚCI ------//
    @OneToMany(mappedBy = "lacznyPlon")
    private List<Plony> plonyRazem;

    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer idPola;

    @NotNull
    private Float lacznaPow;

    @NotNull
    @Column(updatable = false, unique = true)
    private Integer typUprawy;

    private Float zebranyPlon;

    public Integer getIdPola() {
        return idPola;
    }

    public LacznyPlon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
