
package com.example.admin.gmchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NextEvent implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("yes_rsvp_count")
    @Expose
    private Integer yesRsvpCount;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(Integer yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

}
