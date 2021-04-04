package cats.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vote")
public class Vote extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "CREATE_ID_GENERATOR", sequenceName = "vote_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREATE_ID_GENERATOR")
    @Column(nullable = false)
    private Long id;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable = false)
    private Cat cat;

    @Column(nullable = false)
    private Boolean vote;

    @Override
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public Cat getCat() { return cat; }
    public void setCat(Cat cat) { this.cat = cat; }

    public boolean getVote() { return vote; }
    public void setVote(boolean vote) { this.vote = vote; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vote vote1 = (Vote) o;
        return vote == vote1.vote &&
                id.equals(vote1.id) &&
                profile.equals(vote1.profile) &&
                cat.equals(vote1.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, profile, cat, vote);
    }
}
