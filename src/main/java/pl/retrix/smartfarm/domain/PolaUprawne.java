package pl.retrix.smartfarm.domain;

import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class PolaUprawne {

    // *** ENTITY RELATIONS *** //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    // ######################## //
    @OneToMany(mappedBy = "polaUprawne", cascade = CascadeType.ALL)
    List<Plony> plonyList;
    // *** ---------------- *** //



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "polaUprawne_id")
    private Long id;

    @NotBlank(message = "Nazwa pola jest wymagana")
    @Column(unique = true, updatable = false)
    private String nazwaPola;

    @NotNull(message = "Powiechnia pola jest wymagana")
    private Long powierzchnia;

    @Lob
    private String opis;

    @NotBlank(message = "Klasa ziemi jest wymagana")
    private String klasaZiemi;

    public PolaUprawne() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaPola() {
        return nazwaPola;
    }

    public void setNazwaPola(String nazwaPola) {
        this.nazwaPola = nazwaPola;
    }

    public Long getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Long powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKlasaZiemi() {
        return klasaZiemi;
    }

    public void setKlasaZiemi(String klasaZiemi) {
        this.klasaZiemi = klasaZiemi;
    }
}
