package Insurance;

import java.util.ArrayList;

public interface InsuranceList {

	public boolean CreateInsurance(Insurance insurance);
	
	public ArrayList<Insurance> getInsuranceList();
	public Insurance findInsurance(int idx);

}
