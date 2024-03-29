package pl.retrix.smartfarm.domain.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.retrix.smartfarm.domain.*;
import pl.retrix.smartfarm.domain.finanse.Oszczednosci;
import pl.retrix.smartfarm.domain.finanse.Pozyczki;
import pl.retrix.smartfarm.domain.finanse.StanKonta;
import pl.retrix.smartfarm.domain.finanse.Zobowiazania;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class User implements UserDetails {

    // *** ENTITY RELATIONS *** //
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<StanKonta> stanKontaList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Oszczednosci> oszczednosciList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Zobowiazania> zobowiazaniaList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Pozyczki> pozyczkiList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Inwentarz> inwentarzList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Mleko> mlekoList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Magazyn> magazynList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Maszyny> maszynyList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<PolaUprawne> polaUprawneList;
    // *** ---------------- *** //



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Email(message = "Użytkownik musi posiadać adres email")
    @NotBlank(message = "Imię jest wymagane")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Podaj swoje imię i nazwisko")
    private String fullName;

    @NotBlank(message = "Hasło jest wymagane!")
    private String password;

    @Transient
    private String confirmPassword;

    private Date created_At;

    private Date updated_At;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void onCreate() { this.created_At = new Date(); }

    @PreUpdate
    protected void onUpdate() { this.updated_At = new Date(); }

    /*
    UserDetails interface methodscxz
     */

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}