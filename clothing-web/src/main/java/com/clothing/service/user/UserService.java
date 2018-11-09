package com.clothing.service.user;

import com.clothing.model.vo.ResultData;
import com.clothing.model.vo.user.ChangePasswordVo;
import com.clothing.model.vo.user.LoginRequest;

/**
 * 用户业务类
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 登录信息,成功返回token,失败，则返回相应的异常信息
	 * @param loginInfo
	 * @return
	 */
	public ResultData<String> login(LoginRequest loginInfo);
	
	/**
	 * 退出登录
	 * @return
	 */
	ResultData<Void> exit();
	
	/**
	 * 修改密码
	 * @param pwd
	 * @return
	 */
	ResultData<String> changePassword(ChangePasswordVo pwd);
	
}
