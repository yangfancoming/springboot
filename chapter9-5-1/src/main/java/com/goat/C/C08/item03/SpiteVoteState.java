package com.goat.C.C08.item03;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---16:09
 */
public  class  SpiteVoteState  implements  VoteState {

    @Override
    public  void  vote(String user, String voteItem, VoteManager voteManager) {
        //  恶意投票，取消用户的投票资格，并取消投票记录
        String str =  voteManager.getMapVote().get(user);
        if(str !=  null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }

}
