package shop.entity;

import javax.persistence.*;

@Entity
@Table(name ="thing")
public class Thing {

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;

    @Column(name = "id", columnDefinition = "INT UNSIGNED NOT NULL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(name = "cost", columnDefinition = "INT NOT NULL")
    private int cost;

    @Column(name = "thing_size", columnDefinition = "INT NOT NULL")
    private int size;

    @Column(name = "color", columnDefinition = "VARCHAR(255) NOT NULL")
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
