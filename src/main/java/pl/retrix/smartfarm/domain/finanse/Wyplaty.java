package pl.retrix.smartfarm.domain.finanse;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Wyplaty {//TODO: tworzona encja

    @Id
    private Integer id;

    @NotBlank(message = "Kwota jest wymagana")
    private Double kwota;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Data jest wymagana")
    private Date dataDodania;

    public Wyplaty() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }
}