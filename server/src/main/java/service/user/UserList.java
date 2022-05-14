package service.user;

import domain.User;
import repository.UserSearch;

import java.util.ArrayList;
import java.util.List;

public interface UserList {

    //Create
    public void addUser(User user); //회원가입   -파라메터 수정하기


    //Update
    public void modifyCheckSug(Long userIdx); //제안서 확인 업데이트
    public void modifyCheckSub(Long userIdx); //청약서 확인 업데이트


    //Read
    public List<User> findUserList();
    public User findUser(Long userIdx);
    public List<User> findCheckUwUserList(UserSearch userSearch);// 인수검사 통과한 고객 리스트
    public List<User> findDelinquentList();// 미납자 고객 리스트
    public List<User> findMaturityUserList();// 만기 계약 고객 리스트


}
