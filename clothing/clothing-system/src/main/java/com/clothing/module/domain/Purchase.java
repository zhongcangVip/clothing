package com.clothing.module.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.clothing.common.base.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 采购单据表 sys_purchase
 * 
 * @author yangmin
 * @date 2018-11-26
 */
public class Purchase extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer purchaseId;
	/** 采购单号 */
	private String purchaseOrderno;
	/** 供应商编号 */
	private Integer purchaseSupplierId;
	/** 所属门店编号 */
	private Integer deptId;
	/** 来源单据编号 */
	private Integer purchaseSourceId;
	/** 描述 */
	private String purchaseDescription;
	/** 单据状态，是否要经过审核 */
	private String purchaseStatus;
	/** 创建时间 */
	private Date createtime;
	/** 创建人 */
	private Integer createby;
	/** 最后修改时间 */
	private Date lastupdatetime;
	/** 最后修改人 */
	private Integer lastupdateby;
	
	private List<PurchaseDetail> list=new ArrayList<PurchaseDetail>();

	public void setPurchaseId(Integer purchaseId) 
	{
		this.purchaseId = purchaseId;
	}

	public Integer getPurchaseId() 
	{
		return purchaseId;
	}
	public void setPurchaseOrderno(String purchaseOrderno) 
	{
		this.purchaseOrderno = purchaseOrderno;
	}

	public String getPurchaseOrderno() 
	{
		return purchaseOrderno;
	}
	public void setPurchaseSupplierId(Integer purchaseSupplierId) 
	{
		this.purchaseSupplierId = purchaseSupplierId;
	}

	public Integer getPurchaseSupplierId() 
	{
		return purchaseSupplierId;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setPurchaseSourceId(Integer purchaseSourceId) 
	{
		this.purchaseSourceId = purchaseSourceId;
	}

	public Integer getPurchaseSourceId() 
	{
		return purchaseSourceId;
	}
	public void setPurchaseDescription(String purchaseDescription) 
	{
		this.purchaseDescription = purchaseDescription;
	}

	public String getPurchaseDescription() 
	{
		return purchaseDescription;
	}
	public void setPurchaseStatus(String purchaseStatus) 
	{
		this.purchaseStatus = purchaseStatus;
	}

	public String getPurchaseStatus() 
	{
		return purchaseStatus;
	}
	public void setCreatetime(Date createtime) 
	{
		this.createtime = createtime;
	}

	public Date getCreatetime() 
	{
		return createtime;
	}
	public void setCreateby(Integer createby) 
	{
		this.createby = createby;
	}

	public Integer getCreateby() 
	{
		return createby;
	}
	public void setLastupdatetime(Date lastupdatetime) 
	{
		this.lastupdatetime = lastupdatetime;
	}

	public Date getLastupdatetime() 
	{
		return lastupdatetime;
	}
	public void setLastupdateby(Integer lastupdateby) 
	{
		this.lastupdateby = lastupdateby;
	}

	public Integer getLastupdateby() 
	{
		return lastupdateby;
	}

    public List<PurchaseDetail> getList() {
		return list;
	}

	public void setList(List<PurchaseDetail> list) {
		this.list = list;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purchaseId", getPurchaseId())
            .append("purchaseOrderno", getPurchaseOrderno())
            .append("purchaseSupplierId", getPurchaseSupplierId())
            .append("deptId", getDeptId())
            .append("purchaseSourceId", getPurchaseSourceId())
            .append("purchaseDescription", getPurchaseDescription())
            .append("purchaseStatus", getPurchaseStatus())
            .append("createtime", getCreatetime())
            .append("createby", getCreateby())
            .append("lastupdatetime", getLastupdatetime())
            .append("lastupdateby", getLastupdateby())
            .toString();
    }
}
