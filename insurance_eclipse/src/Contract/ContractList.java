package Contract;

import java.sql.ResultSet;

public interface ContractList {
	public ResultSet findContract(Long contractIdx);
	public ResultSet findContractByUserId(Long userIdx);
	public boolean createContract(Contract contract);
	public ResultSet getContractList();
	public boolean deleteContract(Long contractIdx);
}