package service.user;

import domain.User;

import java.util.ArrayList;

public interface UserList {

    public ArrayList<User> findUserList();
    public User findUser();

    // 인수검사 통과한 고객 리스트
    public ArrayList<User> findPassUwUserList();
    // 미납자 고객 리스트
    public ArrayList<User> findDelinquentList();
    // 만기 계약 고객 리스트
    public ArrayList<User> findMaturityUserList();


}
