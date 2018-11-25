package com.clothing.module.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.clothing.common.base.BaseEntity;
import java.util.Date;

/**
 * 商品表 sys_item
 * 
 * @author yangmin
 * @date 2018-11-23
 */
public class Item extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer fid;
	/** 商品编码 */
	private String fcode;
	/**  */
	private String fcu;
	/** 商品名称 */
	private String fname;
	/** 商品简称 */
	private String fshortname;
	/** 商品条码 */
	private String fbarcode;
	/** 规格 */
	private String fspec;
	/** 颜色 */
	private String fcolor;
	/** 尺寸 */
	private String fsize;
	/** 材料 */
	private String fmaterial;
	/** 助记码 */
	private String fhelpcode;
	/** 零售价 */
	private Double fretailprice;
	/** 进货价 */
	private Double fbuyingprice;
	/** 会员价 */
	private Double fvipprice;
	/** 配送价 */
	private Double fdistributionprice;
	/** 商品类别 */
	private String fkcategoryid;
	/** 单位 */
	private String fkunitid;
	/** 供应商 */
	private String fksupplierid;
	/** 最低售价 */
	private Double fminprice;
	/** 第二件售价 */
	private Double ftwoprice;
	/** 产地 */
	private String fplace;
	/** 状态 */
	private String fstatus;
	/** 是否参与积分 0/1 */
	private Integer fintegral;
	/** 描述 */
	private String fdescription;
	/**  */
	private String fuserid;
	/**  */
	private Date fcreatetime;
	/**  */
	private String flastupdateuserid;
	/**  */
	private Date flastupdatetime;
	/** 是否参与折扣 */
	private String fdisCount;

	public void setFid(Integer fid) 
	{
		this.fid = fid;
	}

	public Integer getFid() 
	{
		return fid;
	}
	public void setFcode(String fcode) 
	{
		this.fcode = fcode;
	}

	public String getFcode() 
	{
		return fcode;
	}
	public void setFcu(String fcu) 
	{
		this.fcu = fcu;
	}

	public String getFcu() 
	{
		return fcu;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}

	public String getFname() 
	{
		return fname;
	}
	public void setFshortname(String fshortname) 
	{
		this.fshortname = fshortname;
	}

	public String getFshortname() 
	{
		return fshortname;
	}
	public void setFbarcode(String fbarcode) 
	{
		this.fbarcode = fbarcode;
	}

	public String getFbarcode() 
	{
		return fbarcode;
	}
	public void setFspec(String fspec) 
	{
		this.fspec = fspec;
	}

	public String getFspec() 
	{
		return fspec;
	}
	public void setFcolor(String fcolor) 
	{
		this.fcolor = fcolor;
	}

	public String getFcolor() 
	{
		return fcolor;
	}
	public void setFsize(String fsize) 
	{
		this.fsize = fsize;
	}

	public String getFsize() 
	{
		return fsize;
	}
	public void setFmaterial(String fmaterial) 
	{
		this.fmaterial = fmaterial;
	}

	public String getFmaterial() 
	{
		return fmaterial;
	}
	public void setFhelpcode(String fhelpcode) 
	{
		this.fhelpcode = fhelpcode;
	}

	public String getFhelpcode() 
	{
		return fhelpcode;
	}
	public void setFretailprice(Double fretailprice) 
	{
		this.fretailprice = fretailprice;
	}

	public Double getFretailprice() 
	{
		return fretailprice;
	}
	public void setFbuyingprice(Double fbuyingprice) 
	{
		this.fbuyingprice = fbuyingprice;
	}

	public Double getFbuyingprice() 
	{
		return fbuyingprice;
	}
	public void setFvipprice(Double fvipprice) 
	{
		this.fvipprice = fvipprice;
	}

	public Double getFvipprice() 
	{
		return fvipprice;
	}
	public void setFdistributionprice(Double fdistributionprice) 
	{
		this.fdistributionprice = fdistributionprice;
	}

	public Double getFdistributionprice() 
	{
		return fdistributionprice;
	}
	public void setFkcategoryid(String fkcategoryid) 
	{
		this.fkcategoryid = fkcategoryid;
	}

	public String getFkcategoryid() 
	{
		return fkcategoryid;
	}
	public void setFkunitid(String fkunitid) 
	{
		this.fkunitid = fkunitid;
	}

	public String getFkunitid() 
	{
		return fkunitid;
	}
	public void setFksupplierid(String fksupplierid) 
	{
		this.fksupplierid = fksupplierid;
	}

	public String getFksupplierid() 
	{
		return fksupplierid;
	}
	public void setFminprice(Double fminprice) 
	{
		this.fminprice = fminprice;
	}

	public Double getFminprice() 
	{
		return fminprice;
	}
	public void setFtwoprice(Double ftwoprice) 
	{
		this.ftwoprice = ftwoprice;
	}

	public Double getFtwoprice() 
	{
		return ftwoprice;
	}
	public void setFplace(String fplace) 
	{
		this.fplace = fplace;
	}

	public String getFplace() 
	{
		return fplace;
	}
	public void setFstatus(String fstatus) 
	{
		this.fstatus = fstatus;
	}

	public String getFstatus() 
	{
		return fstatus;
	}
	public void setFintegral(Integer fintegral) 
	{
		this.fintegral = fintegral;
	}

	public Integer getFintegral() 
	{
		return fintegral;
	}
	public void setFdescription(String fdescription) 
	{
		this.fdescription = fdescription;
	}

	public String getFdescription() 
	{
		return fdescription;
	}
	public void setFuserid(String fuserid) 
	{
		this.fuserid = fuserid;
	}

	public String getFuserid() 
	{
		return fuserid;
	}
	public void setFcreatetime(Date fcreatetime) 
	{
		this.fcreatetime = fcreatetime;
	}

	public Date getFcreatetime() 
	{
		return fcreatetime;
	}
	public void setFlastupdateuserid(String flastupdateuserid) 
	{
		this.flastupdateuserid = flastupdateuserid;
	}

	public String getFlastupdateuserid() 
	{
		return flastupdateuserid;
	}
	public void setFlastupdatetime(Date flastupdatetime) 
	{
		this.flastupdatetime = flastupdatetime;
	}

	public Date getFlastupdatetime() 
	{
		return flastupdatetime;
	}
	public void setFdisCount(String fdisCount) 
	{
		this.fdisCount = fdisCount;
	}

	public String getFdisCount() 
	{
		return fdisCount;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fid", getFid())
            .append("fcode", getFcode())
            .append("fcu", getFcu())
            .append("fname", getFname())
            .append("fshortname", getFshortname())
            .append("fbarcode", getFbarcode())
            .append("fspec", getFspec())
            .append("fcolor", getFcolor())
            .append("fsize", getFsize())
            .append("fmaterial", getFmaterial())
            .append("fhelpcode", getFhelpcode())
            .append("fretailprice", getFretailprice())
            .append("fbuyingprice", getFbuyingprice())
            .append("fvipprice", getFvipprice())
            .append("fdistributionprice", getFdistributionprice())
            .append("fkcategoryid", getFkcategoryid())
            .append("fkunitid", getFkunitid())
            .append("fksupplierid", getFksupplierid())
            .append("fminprice", getFminprice())
            .append("ftwoprice", getFtwoprice())
            .append("fplace", getFplace())
            .append("fstatus", getFstatus())
            .append("fintegral", getFintegral())
            .append("fdescription", getFdescription())
            .append("fuserid", getFuserid())
            .append("fcreatetime", getFcreatetime())
            .append("flastupdateuserid", getFlastupdateuserid())
            .append("flastupdatetime", getFlastupdatetime())
            .append("fdisCount", getFdisCount())
            .toString();
    }
}
