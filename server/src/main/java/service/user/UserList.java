package service.user;

import domain.User;

import java.util.ArrayList;

public interface UserList {

    //Create
    public void addUser(int data); //회원가입   -파라메터 수정하기


    //Update
    public void modifyCheckSug(int userIdx); //제안서 확인 업데이트
    public void modifyCheckSub(int userIdx); //청약서 확인 업데이트


    //Read
    public ArrayList<User> findUserList();
    public User findUser(int userIdx);
    public ArrayList<User> findPassUwUserList();// 인수검사 통과한 고객 리스트
    public ArrayList<User> findDelinquentList();// 미납자 고객 리스트
    public ArrayList<User> findMaturityUserList();// 만기 계약 고객 리스트


}
