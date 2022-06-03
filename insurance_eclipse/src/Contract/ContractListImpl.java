package Contract;

 

import java.util.List;

 

import Dao.ContractDao;

 

public class ContractListImpl implements ContractList{

	private ContractDao contractDao = new ContractDao();
	public ContractListImpl( ) {
	}

	@Override
	public boolean createContract(Contract contract) {
		return contractDao.addContract(contract);
	}

	@Override	
	public List<Contract> getContractList() {
		List<Contract> contractList = contractDao.findContractList();
		return contractList;
	}

	

	@Override
	public boolean deleteContract(Long contractIdx) {
		return contractDao.deleteContract(contractIdx);
	}

}

 

 

//	@Override

//	public boolean updateContract() {

//		return contractDao.updateContract();

//	}

	

 

 