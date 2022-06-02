package Contract;

import java.util.ArrayList;

public interface ContractList {
	public Contract findContract(int idx);
	public Contract findContractByUserId(Long idx);
	public boolean CreateContract(Contract contract);
	public ArrayList<Contract> getContractList();
}