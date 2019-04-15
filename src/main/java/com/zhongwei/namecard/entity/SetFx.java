package com.zhongwei.namecard.entity;

import java.math.BigDecimal;

public class SetFx {
    private Integer id;

    private Integer uniacid;

    private int openFx;

    private BigDecimal fxPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public int getOpenFx() {
        return openFx;
    }

    public void setOpenFx(int openFx) {
        this.openFx = openFx;
    }

    public BigDecimal getFxPrice() {
        return fxPrice;
    }

    public void setFxPrice(BigDecimal fxPrice) {
        this.fxPrice = fxPrice;
    }
}