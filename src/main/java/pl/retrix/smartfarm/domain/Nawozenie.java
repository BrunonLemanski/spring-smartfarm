package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Klasa odpowiadająca za encję NAWOZENIE. Ma za zadanie przechowywać
 * informację na temat nawożenia każdej z upraw.
 */

@Entity
public class Nawozenie {

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "plony_id", nullable = false)
    Plony plony;
    // *** ---------------- *** //



    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(updatable = false, unique = true)
    private String idNawozenia;

    @NotNull
    private String typNawozu;

    @NotNull
    private Float iloscNawozu;

    @NotNull
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataNawozenia;

    public Nawozenie() {
    }

    public String getIdNawozenia() {
        return idNawozenia;
    }

    public void setIdNawozenia(String idNawozenia) {
        this.idNawozenia = idNawozenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataNawozenia() {
        return dataNawozenia;
    }

    public void setDataNawozenia(Date dataNawozenia) {
        this.dataNawozenia = dataNawozenia;
    }

}
