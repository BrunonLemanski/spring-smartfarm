package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Klasa odpowiadająca za encję NAWOZENIE. Ma za zadanie przechowywać
 * informację na temat nawożenia każdej z upraw.
 */

@Entity
public class Nawozenie {

    //------- ZALEŻNOŚCI ------//
    @ManyToOne
    private Plony plony;

    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String typNawozu;

    @NotNull
    private Float iloscNawozu;

    @NotNull
    @JsonFormat(pattern = "dd-mm-yy")
    private Date dataNawoenia;

    public Nawozenie() {
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

    public Date getDataNawoenia() {
        return dataNawoenia;
    }

    public void setDataNawoenia(Date dataNawoenia) {
        this.dataNawoenia = dataNawoenia;
    }

    public Plony getPlony() {
        return plony;
    }

    public void setPlony(Plony plony) {
        this.plony = plony;
    }
}
