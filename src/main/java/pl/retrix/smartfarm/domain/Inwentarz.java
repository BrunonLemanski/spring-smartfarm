package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Inwentarz {

    //----------------- ZMIENNE -----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;

    @NotNull(message = "Numer identyfikujący bydło musi zostać podany")
    @Column(unique = true, updatable = false) //musi byc updatable = false, wyszukiwaniew
    private String nrId;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataUr;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataOstatniegoWycielenia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataZasuszenia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataKolejegoWycielenia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataPrzybycia;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataUbycia;

    @NotNull
    private String iloscWycielen;

    @NotNull
    private Long wydajnosc;

    @NotNull
    private int status; //okresla czy zwierze jest w fazie produkcji, zasuszenia czy poza stadem

    //private Long wiek;

    public Inwentarz() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNrId() {
        return nrId;
    }

    public void setNrId(String nrId) {
        this.nrId = nrId;
    }

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    public Date getDataOstatniegoWycielenia() {
        return dataOstatniegoWycielenia;
    }

    public void setDataOstatniegoWycielenia(Date dataOstatniegoWycielenia) {
        this.dataOstatniegoWycielenia = dataOstatniegoWycielenia;
    }

    public Date getDataZasuszenia() {
        return dataZasuszenia;
    }

    public void setDataZasuszenia(Date dataZasuszenia) {
        this.dataZasuszenia = dataZasuszenia;
    }

    public Date getDataKolejegoWycielenia() {
        return dataKolejegoWycielenia;
    }

    public void setDataKolejegoWycielenia(Date dataKolejegoWycielenia) {
        this.dataKolejegoWycielenia = dataKolejegoWycielenia;
    }

    public Date getDataPrzybycia() {
        return dataPrzybycia;
    }

    public void setDataPrzybycia(Date dataPrzybycia) {
        this.dataPrzybycia = dataPrzybycia;
    }

    public Date getDataUbycia() {
        return dataUbycia;
    }

    public void setDataUbycia(Date dataUbycia) {
        this.dataUbycia = dataUbycia;
    }

    public String getIloscWycielen() {
        return iloscWycielen;
    }

    public void setIloscWycielen(String iloscWycielen) {
        this.iloscWycielen = iloscWycielen;
    }

    public Long getWydajnosc() {
        return wydajnosc;
    }

    public void setWydajnosc(Long wydajnosc) {
        this.wydajnosc = wydajnosc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
