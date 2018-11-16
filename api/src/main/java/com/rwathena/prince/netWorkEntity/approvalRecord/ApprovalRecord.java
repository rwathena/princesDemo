package com.rwathena.prince.netWorkEntity.approvalRecord;

import com.rwathena.prince.netWorkEntity.base.BaseEntity;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:35 PM 10/15/2018
 * @ Description:
 * @ Version:     1.0
 */
 public class ApprovalRecord extends BaseEntity{

    private static final long serialVersionUID = 1245973435929981918L;

    private String hsicrmObjectname;

    public String getHsicrmObjectname() {
        return hsicrmObjectname;
    }

    public void setHsicrmObjectname(String hsicrmObjectname) {
        this.hsicrmObjectname = hsicrmObjectname;
    }
}