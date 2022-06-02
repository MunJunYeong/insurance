package Insurance;

import java.util.ArrayList;

import Contract.Contract;

public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;

	public InsuranceListImpl() {
		this.insuranceList = new ArrayList<Insurance>();
	}

	public ArrayList<Insurance> getInsuranceList() {
		return this.insuranceList;
	}

	public boolean CreateInsurance(Insurance insurance) {
		this.insuranceList.add(insurance);
		return true;
	}

	public Insurance findInsurance(int idx) {
		return this.insuranceList.get(idx);
	}

}
