# spring-boot-demo-infotech
# Spring Boot Demo - Category and Product API

This is a Spring Boot application that implements a simple Category-Product management system. It supports features like one-to-many relationships between categories and products, server-side pagination, and fetching product details along with the associated category information.

## 1. Relation between Category and Product (One-to-Many)
- **Category** can have multiple **Products**.
- The relation is implemented as a `@OneToMany` relationship in the `Category` entity, where each category can have a list of products.
- The `Product` entity contains a foreign key reference to the `Category` entity.

### Code for Category Entity:
```java
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column
    private String description;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
    
    // Getters and setters
}




### Code for Product Entity:
```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    // Other fields and getters/setters
}


How Did I Run the Code?
git clone https://github.com/pawardivyas/spring-boot-demo-infotech.git
cd spring-boot-demo-infotech

How Did I Run the Machine Test?
I have used postman 
