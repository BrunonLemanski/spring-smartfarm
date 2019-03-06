package pl.retrix.smartfarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Maszyny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nazwa maszyny jest wymagana")
    private String nazwaMaszyny;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dataSerwisu;

    @Lob
    private String notes;

    public Maszyny() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaMaszyny() {
        return nazwaMaszyny;
    }

    public void setNazwaMaszyny(String nazwaMaszyny) {
        this.nazwaMaszyny = nazwaMaszyny;
    }

    public Date getDataSerwisu() {
        return dataSerwisu;
    }

    public void setDataSerwisu(Date dataSerwisu) {
        this.dataSerwisu = dataSerwisu;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @PrePersist
    protected void onCreate() { this.dataSerwisu = new Date(); }

    @PreUpdate
    protected void onUpdate() { this.dataSerwisu = new Date(); }
}
