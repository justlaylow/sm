package com.tl.sm.pojo;

public class Department {
    private Integer id;

    private String depId;

    private String depName;

    private String depCostCategory;

    private String depRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getDepCostCategory() {
        return depCostCategory;
    }

    public void setDepCostCategory(String depCostCategory) {
        this.depCostCategory = depCostCategory == null ? null : depCostCategory.trim();
    }

    public String getDepRemark() {
        return depRemark;
    }

    public void setDepRemark(String depRemark) {
        this.depRemark = depRemark == null ? null : depRemark.trim();
    }
}