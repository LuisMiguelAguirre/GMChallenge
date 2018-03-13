
package com.example.admin.gmchallenge.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meetup implements Serializable {

    @SerializedName("score")
    private Double score;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("status")
    private String status;
    @SerializedName("link")
    private String link;
    @SerializedName("urlname")
    private String urlname;
    @SerializedName("description")
    private String description;
    @SerializedName("created")
    private Long created;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("localized_country_name")
    private String localizedCountryName;
    @SerializedName("localized_location")
    private String localizedLocation;
    @SerializedName("state")
    private String state;
    @SerializedName("join_mode")
    private String joinMode;
    @SerializedName("visibility")
    private String visibility;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;
    @SerializedName("members")
    private Integer members;
    @SerializedName("organizer")
    private Organizer organizer;
    @SerializedName("who")
    private String who;
    @SerializedName("group_photo")
    private GroupPhoto groupPhoto;
    @SerializedName("key_photo")
    public KeyPhoto keyPhoto;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("next_event")
    private NextEvent nextEvent;
    @SerializedName("category")
    private Category category;
    @SerializedName("meta_category")

    private MetaCategory metaCategory;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalizedCountryName() {
        return localizedCountryName;
    }

    public void setLocalizedCountryName(String localizedCountryName) {
        this.localizedCountryName = localizedCountryName;
    }

    public String getLocalizedLocation() {
        return localizedLocation;
    }

    public void setLocalizedLocation(String localizedLocation) {
        this.localizedLocation = localizedLocation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(String joinMode) {
        this.joinMode = joinMode;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public GroupPhoto getGroupPhoto() {
        return groupPhoto;
    }

    public void setGroupPhoto(GroupPhoto groupPhoto) {
        this.groupPhoto = groupPhoto;
    }

    public KeyPhoto getKeyPhoto() {
        return keyPhoto;
    }

    public void setKeyPhoto(KeyPhoto keyPhoto) {
        this.keyPhoto = keyPhoto;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public NextEvent getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(NextEvent nextEvent) {
        this.nextEvent = nextEvent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MetaCategory getMetaCategory() {
        return metaCategory;
    }

    public void setMetaCategory(MetaCategory metaCategory) {
        this.metaCategory = metaCategory;
    }

}
