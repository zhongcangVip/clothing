package com.clothing.service.impl.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.common.UserConstants;
import com.clothing.dao.RedisDao;
import com.clothing.dao.user.UserDao;
import com.clothing.model.user.User;
import com.clothing.model.vo.ResultData;
import com.clothing.model.vo.user.ChangePasswordVo;
import com.clothing.model.vo.user.LoginRequest;
import com.clothing.model.vo.user.enums.LoginCodeEnum;
import com.clothing.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public ResultData<String> login(LoginRequest loginInfo) {
		//1.判断当前用户是否用户名密码错误次数过多
		String count=redisDao.get(UserConstants.PWD_FAIL_COUNT+loginInfo.getUserName());
		if(StringUtils.isNotBlank(count) && Integer.valueOf(count)>3) {
			return ResultData.getInstance(LoginCodeEnum.LOCKING);
		}
		//2.判断用户名与密码是否正确
		User user=this.userDao.getUserByUserName(loginInfo.getUserName());
		if(user==null) {
			return ResultData.getInstance(LoginCodeEnum.NOT_EXIST);
		}
		String token="";
		return ResultData.getInstance(token);
	}

	@Override
	public ResultData<Void> exit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData<String> changePassword(ChangePasswordVo pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
