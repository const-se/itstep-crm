package shop.entity;

import javax.persistence.*;

@Entity
@Table(name="brand")
public class Brand {
    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(name = "id", columnDefinition = "INT UNSIGNED NOT NULL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
