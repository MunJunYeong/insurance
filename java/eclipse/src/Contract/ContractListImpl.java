package Contract;

import java.util.ArrayList;

public class ContractListImpl implements ContractList{
	
	private ArrayList<Contract> contractList;
	
	public ContractListImpl( ) {
		this.contractList = new ArrayList<Contract>();
	}
	
	public ArrayList<Contract> getContractList() {
		return this.contractList;
	}

	@Override
	public Contract findContract(int idx) {
		return this.contractList.get(idx);
	}

	@Override
	public Contract findContractByUserId(Long idx) {
//		for(int i = 0 ; i < this.contractList.size();i++) {
//			if(this.contractList.get(i).getUser().getUserIdx()==idx) {
//				return this.contractList.get(i);
//			}
//		}
		return null;
	}

	@Override
	public boolean CreateContract(Contract contract) {
		// TODO Auto-generated method stub
		this.contractList.add(contract);
		return true;
	}
}