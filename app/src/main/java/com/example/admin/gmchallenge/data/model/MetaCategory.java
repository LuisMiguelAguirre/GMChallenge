
package com.example.admin.gmchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MetaCategory implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("shortname")
    @Expose
    private String shortname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sort_name")
    @Expose
    private String sortName;
    @SerializedName("photo")
    @Expose
    private Photo_ photo;
    @SerializedName("category_ids")
    @Expose
    private List<Integer> categoryIds = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Photo_ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

}
