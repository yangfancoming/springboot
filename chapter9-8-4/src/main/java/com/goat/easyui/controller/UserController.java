package com.goat.easyui.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.goat.easyui.domain.User;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    private final ResultGenerator generator = new ResultGenerator();

	@Autowired
	private IUserService userService;

//	@RequestMapping("user")
//	public String index(Model model) {
//		User user = super.getCurrentUser();
//		model.addAttribute("user", user);
//		return "/user/userList";
//	}

//    @RequestMapping("/getUser")
//    public RestResult getUser(Long userId) {
//        User user = userService.findById(4L);
//        return generator.getSuccessResult("添加角色成功",user,1);
//    }

    /**
         Map<String, Object> jsonMap = new HashMap<>();
         jsonMap.put("total", pageInfo.getTotal());   // total 存放总记录数
         jsonMap.put("rows", pageInfo.getList());  // rows存放每页记录 ，这里的两个参数名是固定的，必须为 total和 rows
         return jsonMap;
    */
    // http://localhost:8984/user/list
    @RequestMapping("/list")
    public RestResult userList() {
        PageHelper.startPage(1,10);
        List<User> list = userService.selectUserList();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
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
