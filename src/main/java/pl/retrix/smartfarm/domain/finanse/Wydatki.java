package pl.retrix.smartfarm.domain.finanse;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Wydatki {

    @Id
    @Column(name = "wydatki_id")
    private Integer id;

    @NotBlank(message = "Tytul jest wymagany")
    @Column(updatable = false, unique = true)
    private String tytul;

    @NotBlank(message = "Kwota jest wymagana")
    private Integer kwota;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Data jest wymagana")
    private Date dataDodania;

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "stan_id", nullable = false)
    StanKonta stanKonta;
    // *** ---------------- *** //

    public Wydatki() {
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

    public Integer getKwota() {
        return kwota;
    }

    public void setKwota(Integer kwota) {
        this.kwota = kwota;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }
}
