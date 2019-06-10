package com.goat.shiro10.session.dao;


import com.goat.shiro10.util.SerializableUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;


public class MySessionDao extends CachingSessionDAO {


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        System.out.println(sessionId);
        System.out.println(SerializableUtils.serialize(session));
        return session.getId();
    }
    @Override
    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        System.out.println(session.getId());
        System.out.println(SerializableUtils.serialize(session));
    }
    @Override
    protected void doDelete(Session session) {
        System.out.println(session.getId());
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println(sessionId);
        System.out.println(SerializableUtils.deserialize(sessionId.toString()));
        return SerializableUtils.deserialize(sessionId.toString());
    }
}
