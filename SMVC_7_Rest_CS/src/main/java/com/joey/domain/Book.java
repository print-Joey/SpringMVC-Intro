package com.joey.domain;

public class Book {
    private String type;
    private String name;
    private String description;
    private Integer id;

    public Book() {
    }

    public Book(String type, String name, String description, Integer id) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "Book{type = " + type + ", name = " + name + ", description = " + description + ", id = " + id + "}";
    }
}
