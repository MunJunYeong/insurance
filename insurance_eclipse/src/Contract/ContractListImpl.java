package Contract;

import java.sql.ResultSet;
import java.util.List;

import Dao.ContractDao;

public class ContractListImpl implements ContractList{
	
	private ContractDao contractDao = new ContractDao();

	public ContractListImpl( ) {
	}
	
	@Override	
	public ResultSet getContractList() {
		ResultSet rs = contractDao.findContractList();
		return rs;
	}

	@Override
	public ResultSet findContract(Long contractIdx) {
		ResultSet rs = contractDao.findOneContract(contractIdx);
		return rs;
	}

	@Override
	public ResultSet findContractByUserId(Long userIdx) {
		ResultSet rs = contractDao.findContractByUserId(userIdx);
		return rs;
	}

	@Override
	public boolean createContract(Contract contract) {
		return contractDao.addContract(contract);
	}

	@Override
	public boolean deleteContract(Long contractIdx) {
		return contractDao.deleteContract(contractIdx);
	}
}