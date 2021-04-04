package cats.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cat")
public class Cat extends AbstractEntity<Long> implements Serializable {
    @Id
    @SequenceGenerator(name = "CREATE_ID_GENERATOR", sequenceName = "cat_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREATE_ID_GENERATOR")
    @Column(nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String photo;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "cat", cascade = CascadeType.PERSIST)
    @OrderBy("id desc")
    private List<Vote> voteList;

    @Override
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Vote> getVoteList() { return voteList; }
    public void setVoteList(List<Vote> voteList) { this.voteList = voteList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return id.equals(cat.id) &&
                photo.equals(cat.photo) &&
                name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, photo, name);
    }
}
