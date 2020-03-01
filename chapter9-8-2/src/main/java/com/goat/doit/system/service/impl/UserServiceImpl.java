package com.goat.doit.system.service.impl;


//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.doit.system.mapper.UserMapper;
import com.goat.doit.system.mapper.UserRoleMapper;
import com.goat.doit.system.model.RolePermission;
import com.goat.doit.system.model.User;
import com.goat.doit.system.model.UserRole;
import com.goat.doit.system.service.UserService;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.system.vo.UserOnlineVo;
import com.goat.doit.system.vo.base.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public int register(User user) {
        int a = userMapper.insert(user);
        return a;
    }

    @Override
    public void updateLastLoginTime(User user) {
        userMapper.updateLastLoginTime(user);
    }

    @Override
    public List<User> selectUsers(User user) {
        return userMapper.selectUsers(user);
    }

    @Override
    public User selectByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public int updateByUserId(User user) {
        return userMapper.updateByUserId(user);
    }

    @Override
    public int updateStatusBatch(List<String> userIds,Integer status) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("userIds",userIds);
        params.put("status",status);
        return userMapper.updateStatusBatch(params);
    }

    /**
     * 根据用户id分配角色集合
     */
    @Override
    public ResponseVo addAssignRole(String userId, List<String> roleIds) {
        try{
            userRoleMapper.deletes(Integer.valueOf(userId));// 删除 中间表中 所有与该用户关联的角色
            List<UserRole> list = new ArrayList<>();
            for(String roleId :roleIds){
                list.add(new UserRole(userId,roleId));
            }
            int i = userRoleMapper.batchUserRole(list);
            System.out.println(i);
            return ResultUtil.success("分配角色成功");
        }catch(Exception e){
            return ResultUtil.error("分配角色失败");
        }
    }
    /**
     * 根据主键更新用户信息
     *
     * @param user
     * @return int
     */
    @Override
    public int updateUserByPrimaryKey(User user) {
        return 0;
    }

    /** 查询在线用户*/
    @Autowired
    private RedisSessionDAO redisSessionDAO;

    @Override
    public List<UserOnlineVo> selectOnlineUsers(UserOnlineVo userVo) {
        // 因为我们是用redis实现了shiro的session的Dao,而且是采用了shiro+redis这个插件
        // 所以从spring容器中获取redisSessionDAO
        // 来获取session列表.
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        Iterator<Session> it = sessions.iterator();
        List<UserOnlineVo> onlineUserList = new ArrayList<>();
        // 遍历session
        while (it.hasNext()) {
            // 这是shiro已经存入session的
            // 现在直接取就是了
            Session session = it.next();
            //标记为已提出的不加入在线列表
            if(session.getAttribute("kickout") != null) {
                continue;
            }
            UserOnlineVo onlineUser = getSessionBo(session);
            if(onlineUser!=null){
                /*用户名搜索*/
                if(StringUtils.isNotBlank(userVo.getUsername())){
                    if(onlineUser.getUsername().contains(userVo.getUsername()) ){
                        onlineUserList.add(onlineUser);
                    }
                }else{
                    onlineUserList.add(onlineUser);
                }
            }
        }
        return onlineUserList;
    }
    /**
     * 踢出用户
     * @param sessionId 会话id
     * @param username  用户名
     */
    @Override
    public void kickout(Serializable sessionId, String username) {

    }

    /** 根据角色id下的所有用户 */
    @Override
    public List<User> findByRoleId(Integer roleId) {
        return userMapper.findByRoleId(roleId);
    }


    private UserOnlineVo getSessionBo(Session session){
        //获取session登录信息。
        Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if(null == obj){
            return null;
        }
        //确保是 SimplePrincipalCollection对象。
        if(obj instanceof SimplePrincipalCollection){
            SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
            obj = spc.getPrimaryPrincipal();
            if(null != obj && obj instanceof User){
                User user = (User) obj;
                //存储session + user 综合信息
                UserOnlineVo userBo = new UserOnlineVo();
                //最后一次和系统交互的时间
                userBo.setLastAccess(session.getLastAccessTime());
                //主机的ip地址
                userBo.setHost(user.getLoginIpAddress());
                //session ID
                userBo.setSessionId(session.getId().toString());
                //最后登录时间
                userBo.setLastLoginTime(user.getLastLoginTime());
                //回话到期 ttl(ms)
                userBo.setTimeout(session.getTimeout());
                //session创建时间
                userBo.setStartTime(session.getStartTimestamp());
                //是否踢出
                userBo.setSessionStatus(false);
                /*用户名*/
                userBo.setUsername(user.getUsername());
                return userBo;
            }
        }
        return null;
    }
}
