package pl.retrix.smartfarm.domain.finanse;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Oszczednosci {//TODO: tworzona encja

    @Id
    private Integer id;

    @NotBlank(message = "Kwota jest wymagana")
    private Double kwota;

    @NotBlank(message = "Data jest wymagana")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataWplaty;

    public Oszczednosci() {
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

    public Date getDataWplaty() {
        return dataWplaty;
    }

    public void setDataWplaty(Date dataWplaty) {
        this.dataWplaty = dataWplaty;
    }
}
