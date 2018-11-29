package shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(name = "id", columnDefinition = "INT UNSIGNED NOT NULL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
