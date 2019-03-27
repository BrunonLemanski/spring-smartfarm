package pl.retrix.smartfarm.domain.finanse;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Zobowiazania {//TODO: tworzona encja

    @Id
    private Integer id;

    @NotBlank(message = "Tytul jest wymagany")
    @Column(updatable = false, unique = true)
    private String tytul;

    @NotBlank(message = "Kwota jest wymagana")
    private Double kwota;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotBlank(message = "Data jest wymagana")
    private Date dataZaciagniecia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataSplaty;

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //

    public Zobowiazania() {
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

    public Date getDataZaciagniecia() {
        return dataZaciagniecia;
    }

    public void setDataZaciagniecia(Date dataZaciagniecia) {
        this.dataZaciagniecia = dataZaciagniecia;
    }

    public Date getDataSplaty() {
        return dataSplaty;
    }

    public void setDataSplaty(Date dataSplaty) {
        this.dataSplaty = dataSplaty;
    }
}
