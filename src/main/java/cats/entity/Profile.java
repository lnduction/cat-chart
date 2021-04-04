package cats.entity;

import cats.annotation.constraints.EnglishLanguage;
import cats.annotation.constraints.PasswordStrength;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profile")
public class Profile extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "CREATE_ID_GENERATOR", sequenceName = "profile_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREATE_ID_GENERATOR")
    @Column(nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotNull(message = "NotNull")
    private String name;

    @Column(length = 50, nullable = false)
    @NotNull(message = "NotNull")
    private String password;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.PERSIST)
    @OrderBy("id desc")
    private List<Vote> voteList;

    public Profile(Long id) { this.id = id; }
    public Profile() {}

    @Override
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Vote> getVoteList() { return voteList; }
    public void setVoteList(List<Vote> voteList) { this.voteList = voteList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profile profile = (Profile) o;
        return id.equals(profile.id) &&
                name.equals(profile.name) &&
                password.equals(profile.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, password);
    }
}
