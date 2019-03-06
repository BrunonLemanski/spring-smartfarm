package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Plony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //TODO: Utworzyć encję 'ŁącznyPlon'. Będzie potrzebne do wyświetlania i zarządzania danymi w finalnej wersji app
    //LacznyPlon
    //private Integer idPola;
    //private Float lacznaPow;
    //private String nawozenie;
    //private Float zebranyPlon;
}
