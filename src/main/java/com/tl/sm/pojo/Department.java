package com.tl.sm.pojo;

public class Department {
    private Integer id;
    //工号
    private String depId;
    //部门名称
    private String depName;
    //成本类别
    private String depCostCategory;
    //备注
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