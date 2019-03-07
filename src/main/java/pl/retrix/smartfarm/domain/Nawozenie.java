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
    private Plony nawozeniePlonyPath;

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
    private Date dataNawozenia;

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
        return dataNawozenia;
    }

    public void setDataNawoenia(Date dataNawozenia) {
        this.dataNawozenia = dataNawozenia;
    }

}
