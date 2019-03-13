package pl.retrix.smartfarm.domain.finanse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class StanKonta {//TODO: tworzona encja

    @Id
    private Integer id;

    private Double stan; //wyplata + przychody - wydatki

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
