package com.rwathena.prince.netWorkEntity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:30 PM 10/15/2018
 * @ Description:
 * @ Version:     1.0
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -267079490121753956L;
    private Date modifiedOn;
    private Date createdOn;
    private String modifiedByName;
    private String createdByName;

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }
}