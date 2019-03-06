package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Klasa odpowiadająca za encję PLONY. Zawiera relację z
 * encją LacznyPlon oraz Nawozenie, które są podrzedne.
 */

@Entity
public class Plony {

    //TODO: INFO 2. Mapowanie relacji pomiędzy encjami
    //------- ZALEŻNOŚCI ------//
    @OneToOne(mappedBy = "plony")
    private List<LacznyPlon> zasianePlony;

    @OneToMany(mappedBy = "nawozenie")
    private List<Nawozenie> nawozPlon; //TODO: Rozwiązać problem z encjami.

    //------- ZMIENNE ------//

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Wskaż pole, na którym chcesz dodać plon") //TODO: pobieranie powierzchni pola i wyliczanie ile z niego zostało juz wykorzystane. W rozwijanym MENU pkt. 'Dostępne: 2,1ha'. Wykres użycia pól w zakładce Plony
    private Integer idPola;

    @NotNull(message = "Podaj typ uprawy") //TODO: dostępne typy uprawy z rozwijanego menu
    private Integer typ;

    @NotNull(message = "Podaj powierzchnię uprawy")
    private Float powierzchnia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotNull(message = "Podaj datę siewu")
    private Date dataSiewu;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataZbioru;

    public Plony() { }

    public Long getId() {
        return id;
    }

    public Integer getIdPola() { return idPola; }

    public void setIdPola(Integer idPola) { this.idPola = idPola; }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }

    public Float getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Float powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public Date getDataSiewu() {
        return dataSiewu;
    }

    public void setDataSiewu(Date dataSiewu) {
        this.dataSiewu = dataSiewu;
    }

    public Date getDataZbioru() {
        return dataZbioru;
    }

    public void setDataZbioru(Date dataZbioru) {
        this.dataZbioru = dataZbioru;
    }

    public List<LacznyPlon> getZasianePlony() {
        return zasianePlony;
    }

    public void setZasianePlony(List<LacznyPlon> zasianePlony) {
        this.zasianePlony = zasianePlony;
    }

    public List<Nawozenie> getNawozPlon() {
        return nawozPlon;
    }

    public void setNawozPlon(List<Nawozenie> nawozPlon) {
        this.nawozPlon = nawozPlon;
    }
}
