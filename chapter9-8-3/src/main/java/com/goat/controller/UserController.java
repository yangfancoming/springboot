package com.goat.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.domain.QueryRequest;
import com.goat.domain.User;
import com.goat.resultmodel.RestResult;
import com.goat.resultmodel.ResultGenerator;
import com.goat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController   {

    private final ResultGenerator generator = new ResultGenerator();

	@Autowired
	private IUserService userService;

//	@RequestMapping("user")
//	public String index(Model model) {
//		User user = super.getCurrentUser();
//		model.addAttribute("user", user);
//		return "/user/userList";
//	}

    @RequestMapping("/getUser")
    public RestResult getUser(Long userId) {
        User user = userService.findById(4L);
        return generator.getSuccessResult("添加角色成功",user,1);
    }

	@RequestMapping("/list")
	public RestResult userList(QueryRequest request, User user) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<User> list = userService.findUserWithDept(user);
		PageInfo<User> pageInfo = new PageInfo<>(list);
        RestResult datang = generator.getSuccessResult("datang", pageInfo.getList(), pageInfo.getTotal());
        return datang;
	}
//
//
//
//	@RequestMapping("user/delete")
//	@ResponseBody
//	public ResponseBo deleteUsers(String ids) {
//		try {
//			this.userService.deleteUsers(ids);
//			return ResponseBo.ok("删除用户成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("删除用户失败，请联系网站管理员！");
//		}
//	}

}
