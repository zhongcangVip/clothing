package com.clothing.dao.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.clothing.common.UserConstants;
import com.clothing.model.base.Entity;
import com.clothing.model.vo.user.UserVo;

/**
 * mybatis 栏截器
 * 为mybatis 的查询添加cu参数与新增修改的entity实体添加cu值
 * @author yangmin
 * @Date:2018年10月25日
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,Object.class}) })
@Component
@Configuration
public class QueryInterceptor implements Interceptor{
	
	private final static Logger logger=LoggerFactory.getLogger(QueryInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		final Object[] ary=invocation.getArgs();
		MappedStatement ms = (MappedStatement) ary[0];
		Object obj=ary[1];
		if(ms==null){
			return invocation.proceed();
		}
		UserVo currentUser=UserConstants.CURRENT_USER.get();
		if(currentUser==null){
			return invocation.proceed();
		}
		if(obj==null){
			ParameterMap pMap=ms.getParameterMap();
			if(pMap.getType() == HashMap.class){
				Map<String,Object> param=(Map<String, Object>) obj;
				param.put("cu", currentUser.getShopId());
				ary[1]=param;
			}
		}else if(obj instanceof java.util.HashMap){
			Map<String,Object> param=(Map<String, Object>) obj;
			param.put("cu", currentUser.getShopId());
			ary[1]=param;
		}else if(obj instanceof Entity){
			Entity entity=(Entity) obj;
			entity.setCu(Integer.valueOf(currentUser.getShopId()));
			ary[1]=entity;
		}
		logger.info("intercept");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object obj) {
		// TODO Auto-generated method stub
		 return Plugin.wrap(obj, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
