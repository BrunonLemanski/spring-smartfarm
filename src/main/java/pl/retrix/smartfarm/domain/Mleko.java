package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Mleko {

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ilość mleka jest wymagana")
    @Size(min = 3, max = 5, message = "Wprowadź conajmniej 100 litrów mleka i conajwyżej 99999 l")
    private String iloscMleko;

    //TODO napisać sekwencje dla odbiorów w miesiacu tzn. 1-15 odbiorów i w kolejnym miesiącu od 1
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nrOdbioru;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @Column(unique = true, updatable = false)
    private Date dataOdbioru;

    public Mleko(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIloscMleko() {
        return iloscMleko;
    }

    public void setIloscMleko(String iloscMleko) {
        this.iloscMleko = iloscMleko;
    }

    public Long getNrOdbioru() {
        return nrOdbioru;
    }

    public void setNrOdbioru(Long nrOdbioru) {
        this.nrOdbioru = nrOdbioru;
    }

    public Date getDataOdbioru() {
        return dataOdbioru;
    }

    public void setDataOdbioru(Date dataOdbioru) {
        this.dataOdbioru = dataOdbioru;
    }

    @PrePersist
    protected void onCreate() { this.dataOdbioru = new Date(); }
}
