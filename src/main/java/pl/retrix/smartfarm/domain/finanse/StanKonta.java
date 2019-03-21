package pl.retrix.smartfarm.domain.finanse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class StanKonta {//TODO: tworzona encja

    @Id
    @Column(name = "stan_id")
    private Integer id;

    private Double stan; //wyplata + przychody - wydatki

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stan_id", referencedColumnName = "stan_id")
    private List<Wydatki> wydatkiList;

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
