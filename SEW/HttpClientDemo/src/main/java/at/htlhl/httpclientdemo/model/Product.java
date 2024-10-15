package at.htlhl.httpclientdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int id;

    private String name;

    // @JsonProperty(value = "product_group") braucht man weil in JSON die Variable self_link heißt

    @JsonProperty(value = "self_link")
    private String selfLink;

    public Product() {

    }


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

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selfLink='" + selfLink + '\'' +
                '}';
    }
}
