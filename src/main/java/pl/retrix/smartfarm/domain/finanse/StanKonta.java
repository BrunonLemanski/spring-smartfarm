package pl.retrix.smartfarm.domain.finanse;

import pl.retrix.smartfarm.domain.accounts.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class StanKonta {//TODO: tworzona encja

    @Id
    @Column(name = "stan_id")
    private Integer id;

    private Double stan; //wyplata + przychody - wydatki

    // *** ENTITY RELATIONS *** //
    @OneToMany(mappedBy = "stanKonta", cascade = CascadeType.ALL)
    List<Wydatki> wydatkiList;

    @OneToMany(mappedBy = "stanKonta", cascade = CascadeType.ALL)
    List<Przychody> przychodyList;

    @OneToMany(mappedBy = "stanKonta", cascade = CascadeType.ALL)
    List<Wyplaty> wyplatyList;

    // ######################## //
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    // *** ---------------- *** //

    public StanKonta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getStan() {
        return stan;
    }

    public void setStan(Double stan) {
        this.stan = stan;
    }
}
