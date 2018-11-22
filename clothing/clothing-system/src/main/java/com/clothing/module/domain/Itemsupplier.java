package com.clothing.module.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.clothing.common.base.BaseEntity;
import java.util.Date;

/**
 * 商品供应商表 sys_itemsupplier
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public class Itemsupplier extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer fid;
	/**  */
	private String fcode;
	/**  */
	private String fname;
	/**  */
	private String faddress;
	/**  */
	private String fcontacts;
	/**  */
	private String fmobile;
	/**  */
	private String fqq;
	/**  */
	private String fwx;
	/**  */
	private String femail;
	/**  */
	private String fstatus;
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
	public void setFaddress(String faddress) 
	{
		this.faddress = faddress;
	}

	public String getFaddress() 
	{
		return faddress;
	}
	public void setFcontacts(String fcontacts) 
	{
		this.fcontacts = fcontacts;
	}

	public String getFcontacts() 
	{
		return fcontacts;
	}
	public void setFmobile(String fmobile) 
	{
		this.fmobile = fmobile;
	}

	public String getFmobile() 
	{
		return fmobile;
	}
	public void setFqq(String fqq) 
	{
		this.fqq = fqq;
	}

	public String getFqq() 
	{
		return fqq;
	}
	public void setFwx(String fwx) 
	{
		this.fwx = fwx;
	}

	public String getFwx() 
	{
		return fwx;
	}
	public void setFemail(String femail) 
	{
		this.femail = femail;
	}

	public String getFemail() 
	{
		return femail;
	}
	public void setFstatus(String fstatus) 
	{
		this.fstatus = fstatus;
	}

	public String getFstatus() 
	{
		return fstatus;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fid", getFid())
            .append("fcode", getFcode())
            .append("fname", getFname())
            .append("faddress", getFaddress())
            .append("fcontacts", getFcontacts())
            .append("fmobile", getFmobile())
            .append("fqq", getFqq())
            .append("fwx", getFwx())
            .append("femail", getFemail())
            .append("fstatus", getFstatus())
            .append("fuserid", getFuserid())
            .append("fcreatetime", getFcreatetime())
            .append("flastupdateuserid", getFlastupdateuserid())
            .append("flastupdatetime", getFlastupdatetime())
            .append("fcu", getFcu())
            .toString();
    }
}
