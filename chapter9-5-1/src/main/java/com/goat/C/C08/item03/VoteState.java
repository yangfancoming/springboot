package com.goat.C.C08.item03;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---16:06
 */
public interface VoteState {
    /**
     * 处理状态对应的行为
     * @param user    投票人
     * @param voteItem    投票项
     * @param voteManager    投票上下文，用来在实现状态对应的功能处理的时候，可以回调上下文的数据
     */
    public void vote(String user,String voteItem,VoteManager voteManager);
}
