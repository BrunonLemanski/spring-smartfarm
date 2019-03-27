package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Magazyn {

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //


    //----------------- ZMIENNE -----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nazwa towaru jest wymagana")
    @Column(unique = true, updatable = false)
    private String nazwaTowaru;

    @NotNull(message = "Ilość towaru jest wymagana")
    private String iloscTowaru;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataDodania;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataAktualizacji;


    public Magazyn (){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public String getIloscTowaru() {
        return iloscTowaru;
    }

    public void setIloscTowaru(String iloscTowaru) {
        this.iloscTowaru = iloscTowaru;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public Date getDataAktualizacji() {
        return dataAktualizacji;
    }

    public void setDataAktualizacji(Date dataAktualizacji) {
        this.dataAktualizacji = dataAktualizacji;
    }

    @PrePersist
    protected void onCreate(){ this.dataDodania = new Date(); }

    @PreUpdate
    protected void onUpdate(){ this.dataAktualizacji = new Date(); }


}
