package pl.retrix.smartfarm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class LacznyPlon {

    // *** ENTITY RELATIONS *** //
    @OneToMany(mappedBy = "lacznyPlon", cascade = CascadeType.ALL)
    List<Plony> plonyList;
    // *** ---------------- *** //

    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    @Column(name = "lacznyPlon_id")
    private Integer id;

    @NotNull
    private String idPola;

    @NotNull
    private Float lacznaPow;

    @NotNull
    @Column(updatable = false, unique = true)
    private Integer typUprawy;

    private Float zebranyPlon;

    public String getIdPola() {
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

    public void setIdPola(String idPola) {
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
