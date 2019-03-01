package com.wsf.controller;

import com.wsf.Condition.UserCondition;
import com.wsf.model.Page;
import com.wsf.model.TUser;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.wsf.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:00
 * @tel:18738322951
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录方法
     * @param user
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/login.do")
    public String login(TUser user, HttpSession session, Model model){
        //进行查询
        TUser u = userService.login(user);
        //保存用户信息到session中
        session.setAttribute("user",u);
        if(u == null){
            model.addAttribute("username",user.getUsername());
            model.addAttribute("error","用户名或者密码错误");
            return "login";
        }
        return "page/index";
    }


    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        //移除session中的用户
        session.removeAttribute("user");
        return "login";
    }


    /**
     * 查询用户
     * @param userId
     * @return
     */
    @RequestMapping("/selectUserById.do")
    public @ResponseBody TUser selectUserById(Integer userId){
        TUser user = userService.selectUserById(userId);
        return user;

    }
    /**
     * 根据条件查询用户
     * @param condition
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/selectUserByCondition.do")
    public  String  selectUserByCondition(UserCondition condition,Model model) throws IOException {
        String type = condition.getSearchType();
        if("userId".equals(type)){
            try{
                condition.setUserId(Integer.valueOf(condition.getSearchValue()));
            }catch (Exception e){
            }
        }else if("name".equals(type)){
              condition.setName(condition.getSearchValue());
        }else if("privilege".equals(type)){
            try {
                condition.setPrivilege(Integer.valueOf(condition.getSearchValue()));
            }catch (Exception e){
            }
        }
        if(condition.getPageNo() == null){
            condition.setPageNo(1);
        }
        Page<TUser> page = userService.selectAllUser(condition);
        model.addAttribute("page",page);
        model.addAttribute("condition",condition);
        System.out.println(page);
        return "page/user";
    }

    /**
     * 进行用户验证
     * @return
     */
    @RequestMapping("/validate.do")
    public void validate(String username, HttpServletResponse response) throws IOException {
        System.out.println(username);
        TUser user = userService.validate(username);
        if(user==null){
            //用户不存在，可以进行注册
            response.getWriter().write("1");
        }else{
            //用户存在不能注册
            response.getWriter().write("0");
        }
    }

    /**
     * 用户修改
     */

    /**
     * 用户注册
     */
    @RequestMapping("/saveOrUpdate.do")
    public String saveOrUpdate(TUser user){
        if(user.getUserId()==null){
            //说明是注册
            userService.regist(user);
        }else{
            //说明是更新
            userService.updateUserById(user);
        }
        return "redirect:/user/selectUserByCondition.do";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserById.do")
    public void deleteUserById(Integer userId){
        userService.deleteUserById(userId);
    }

}
