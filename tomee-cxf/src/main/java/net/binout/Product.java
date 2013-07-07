package net.binout;

import javax.xml.bind.annotation.XmlRootElement;

// Use jettison as JSON marshaller
@XmlRootElement(name="product", namespace = "")
public class Product {

    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
