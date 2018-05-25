package cn.qhjys.crm.entity;

import java.io.Serializable;
import java.util.Date;

public class CrmUser implements Serializable {
    private Long id;

    private String userName;

    private String userAccount;

    private String userPassword;

    private Long deptId;

    private Long serviceGroupId;

    private Integer workState;

    private Date inputTime;

    private Integer delFlag;

    private String p2pMobile;

    private Long p2pUserId;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getServiceGroupId() {
        return serviceGroupId;
    }

    public void setServiceGroupId(Long serviceGroupId) {
        this.serviceGroupId = serviceGroupId;
    }

    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getP2pMobile() {
        return p2pMobile;
    }

    public void setP2pMobile(String p2pMobile) {
        this.p2pMobile = p2pMobile == null ? null : p2pMobile.trim();
    }

    public Long getP2pUserId() {
        return p2pUserId;
    }

    public void setP2pUserId(Long p2pUserId) {
        this.p2pUserId = p2pUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", deptId=").append(deptId);
        sb.append(", serviceGroupId=").append(serviceGroupId);
        sb.append(", workState=").append(workState);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", p2pMobile=").append(p2pMobile);
        sb.append(", p2pUserId=").append(p2pUserId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}