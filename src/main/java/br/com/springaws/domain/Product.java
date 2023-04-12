package br.com.springaws.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private Date dateCreated;
    private Date lastUpdated;
    private String name;
    private String subtitle;
    @Column(length = 2000)
    private String description;

    @ManyToOne
    private Author author;
    private BigDecimal price;

    @Builder.Default
    @ManyToMany
    private List<ProductCategory> productCategories = new ArrayList<>();
    public Product(Integer id, Integer version, String name, String subtitle) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.subtitle = subtitle;
    }
    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}
