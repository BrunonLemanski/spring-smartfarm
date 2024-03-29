package pl.retrix.smartfarm.domain.finanse;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Pozyczki {

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //



    @Id
    private Integer id;

    @NotBlank(message = "Tytuł jest wymagany")
    @Column(updatable = false, unique = true)
    private String tytul;

    @NotBlank(message = "Kwota jest wymagana")
    private Double kwota;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Wysokość raty miesięcznej jest wymagane")
    private Date rataMiesieczna;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Data rozpoczęcia okresu kredytowego jest wymagana")
    private Date dataRozpoczecia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Data spłaty kredytu jest wymagana")
    private Date dataZakonczenia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Oprocentowanie kredytu jest wymagane")
    private Date oprocentowanie;

    private Double odsetkiLacznie;

    public Pozyczki() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Date getRataMiesieczna() {
        return rataMiesieczna;
    }

    public void setRataMiesieczna(Date rataMiesieczna) {
        this.rataMiesieczna = rataMiesieczna;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public Date getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(Date oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public Double getOdsetkiLacznie() {
        return odsetkiLacznie;
    }

    public void setOdsetkiLacznie(Double odsetkiLacznie) {
        this.odsetkiLacznie = odsetkiLacznie;
    }
}
