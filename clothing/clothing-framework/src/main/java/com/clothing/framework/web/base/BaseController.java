package com.clothing.framework.web.base;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.helper.DataUtil;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.clothing.common.OrderNoConstants;
import com.clothing.common.base.AjaxResult;
import com.clothing.common.utils.DateUtils;
import com.clothing.common.utils.StringUtils;
import com.clothing.framework.util.HanyuPinyinHelper;
import com.clothing.framework.util.ShiroUtils;
import com.clothing.framework.web.page.PageDomain;
import com.clothing.framework.web.page.TableDataInfo;
import com.clothing.framework.web.page.TableSupport;
import com.clothing.system.domain.SysUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
    /**
     * 单号生成规则,前缀+店铺编码+YYYYMMDD+四位随便数
     * @param prefix
     * @return
     */
    public static String getOrderNo(String prefix){
    	String deptName=ShiroUtils.getUser().getDept().getDeptName();
    	int result=Math.abs(UUID.randomUUID().toString().hashCode())%10000;
    	String number=prefix+HanyuPinyinHelper.getFirstLettersUp(deptName);
    	number+=DateUtils.dateTimeNow("yyyyMMdd");
    	number=number+result;
    	return number;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message)
    {
        return AjaxResult.error(code, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    public SysUser getUser()
    {
        return ShiroUtils.getUser();
    }

    public void setUser(SysUser user)
    {
        ShiroUtils.setUser(user);
    }

    public Long getUserId()
    {
        return getUser().getUserId();
    }

    public String getLoginName()
    {
        return getUser().getLoginName();
    }
    
}
