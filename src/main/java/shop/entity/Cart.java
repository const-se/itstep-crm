package shop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Column(name = "id", columnDefinition = "INT UNSIGNED NOT NULL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(targetEntity = Thing.class, cascade = CascadeType.ALL)
    @JoinTable(
        name = "cart_thing",
        joinColumns={@JoinColumn(name="cart_id", referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="thing_id", referencedColumnName="id")}
    )
    private Set<Thing> things = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Thing> getThings() {
        return things;
    }

    public void setThings(Set<Thing> things) {
        this.things = things;
    }
}
