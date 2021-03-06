package com.clothing.module.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.clothing.common.base.BaseEntity;
import java.util.Date;

/**
 * 商品类别表 sys_itemcategory
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public class Itemcategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer fid;
	/**  */
	private String fcode;
	/**  */
	private String fname;
	/**  */
	private String fstatus;
	/**  */
	private String fkparentid;
	/**  */
	private String fuserid;
	/**  */
	private Date fcreatetime;
	/**  */
	private String flastupdateuserid;
	/**  */
	private Date flastupdatetime;
	/**  */
	private String fcu;
	
	private boolean flag;//是否选择。不存放数据库

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
	public void setFname(String fname) 
	{
		this.fname = fname;
	}

	public String getFname() 
	{
		return fname;
	}
	public void setFstatus(String fstatus) 
	{
		this.fstatus = fstatus;
	}

	public String getFstatus() 
	{
		return fstatus;
	}
	public void setFkparentid(String fkparentid) 
	{
		this.fkparentid = fkparentid;
	}

	public String getFkparentid() 
	{
		return fkparentid;
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
	public void setFcu(String fcu) 
	{
		this.fcu = fcu;
	}

	public String getFcu() 
	{
		return fcu;
	}

	
    public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fid", getFid())
            .append("fcode", getFcode())
            .append("fname", getFname())
            .append("fstatus", getFstatus())
            .append("fkparentid", getFkparentid())
            .append("fuserid", getFuserid())
            .append("fcreatetime", getFcreatetime())
            .append("flastupdateuserid", getFlastupdateuserid())
            .append("flastupdatetime", getFlastupdatetime())
            .append("fcu", getFcu())
            .toString();
    }
}
