package aop;

/**
 * Created by SF on 2017/12/15.
 */
public class UserMgrImp implements UserMgr {
    @Override
    public void addUser() {
        System.out.println("UserMgrImp-addUser()");
    }

    @Override
    public void delUser() {
        System.out.println("UserMgrImp-delUser()");
    }
}
