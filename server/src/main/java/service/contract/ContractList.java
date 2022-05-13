package service.contract;

import domain.Contract;

import java.util.ArrayList;

public interface ContractList {


    //Create
    public void addContract();  //


    //Read
    public Contract findContract(); //제안서 및 청약서 가져올 때
    public ArrayList<Contract> findContractList(); //UW가 인수검사할 계약 리스트들

    //Update
    public void modifyCheckUw(int contractIdx);
    //checkUw가 되면은 계약이 성립되는 것이기에 트랜잭션으로 묶어서 동시적으로 발생시켜야 할지?
    public void modifyContractDate(int contractIdx);
}
