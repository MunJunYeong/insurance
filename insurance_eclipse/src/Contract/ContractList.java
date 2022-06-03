package Contract;

 

import java.util.List;

 

public interface ContractList {

	public boolean createContract(Contract contract);
	public List<Contract> getContractList();
	public boolean deleteContract(Long contractIdx);
//	public boolean updateContract();
	
}

 

 

 