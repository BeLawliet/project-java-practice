package com.app.project.models;

public class Category implements Comparable<Category> {
    private Integer categoryId;
    private String description;
    private static int lastId;

    public Category() {
        this.categoryId = ++lastId;
    }

    public Category(String description) {
        this();
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void showCategories() {
        System.out.println("Category = { Id: " + this.categoryId + ", Description: '" + this.description + "' }");
    }

    @Override
    public String toString() {
        return this.description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Category other = (Category) obj;
        if (categoryId == null) {
            if (other.categoryId != null) return false;
        } else if (!categoryId.equals(other.categoryId)) return false;
        
        return true;
    }

    @Override
    public int compareTo(Category o) {
        if (this.categoryId.equals(o.categoryId)) return 0;
        return (this.categoryId > o.categoryId) ? 1 : -1;
    }
}
