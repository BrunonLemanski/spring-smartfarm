package pl.retrix.smartfarm.domain.finanse;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Oszczednosci {

    @Id
    private Integer id;

    @NotBlank(message = "Kwota jest wymagana")
    private Double kwota;

    @NotBlank
    @Column(updatable = false, unique = true)
    private String idOszczednosci;

    @NotBlank(message = "Data jest wymagana")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataWplaty;

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //

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

    public String getIdOszczednosci() {
        return idOszczednosci;
    }

    public void setIdOszczednosci(String idOszczednosci) {
        this.idOszczednosci = idOszczednosci;
    }

    public Date getDataWplaty() {
        return dataWplaty;
    }

    public void setDataWplaty(Date dataWplaty) {
        this.dataWplaty = dataWplaty;
    }
}
