package com.softwareengieering.bellisimo;
import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "ProductItem")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String category;
    private String categoryType;
    private String categorySubType;
    private String description;
    private String size;
    private double price;
    private String imagePath;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory ( String category ) {
        this.category = category;
    }

    public String getCategoryType () {
        return categoryType;
    }

    public void setCategoryType ( String categoryType ) {
        this.categoryType = categoryType;
    }

    public String getCategorySubType () {
        return categorySubType;
    }

    public void setCategorySubType ( String categorySubType ) {
        this.categorySubType = categorySubType;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getSize () {
        return size;
    }

    public void setSize ( String size ) {
        this.size = size;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public String getImagePath () {
        return imagePath;
    }

    public void setImagePath ( String imagePath ) {
        this.imagePath = imagePath;
    }

}
