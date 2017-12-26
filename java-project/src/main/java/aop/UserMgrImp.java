package aop;

import common.use.Person;

/**
 * Created by SF on 2017/12/15.
 */
public class UserMgrImp implements UserMgr {
    @Override
    @ParameterChange(parameterClass = UserMgrImp.class, parameterIndex = 1)
    public void addUser(Person person) {
        System.out.println("UserMgrImp-addUser()");
    }

    @Override
    public void delUser() {
        System.out.println("UserMgrImp-delUser()");
    }
}
