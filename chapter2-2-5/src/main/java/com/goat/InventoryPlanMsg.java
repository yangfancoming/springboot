package com.goat;

import java.io.Serializable;

/**
 * Created by 64274 on 2018/12/3.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/12/3---9:57
 */
public class InventoryPlanMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pn;

    private String materialName;


    private String standard;

    private String model;

    private Long count;


    private Long inventoryCount;


    private Long differenceCount;

    private String upn;

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Long getDifferenceCount() {
        return differenceCount;
    }

    public void setDifferenceCount(Long differenceCount) {
        this.differenceCount = differenceCount;
    }

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn;
    }
}

