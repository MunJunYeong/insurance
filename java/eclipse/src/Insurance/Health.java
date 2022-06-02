package Insurance;

public class Health extends Insurance {

    private Long insuranceIdx;
    private int healthGrade;
    
	public Health(Long insuranceIdx, int healthGrade) {
		super();
		this.insuranceIdx = insuranceIdx;
		this.healthGrade = healthGrade;
	}
	
	public Long getInsuranceIdx() {
		return insuranceIdx;
	}
	public void setInsuranceIdx(Long insuranceIdx) {
		this.insuranceIdx = insuranceIdx;
	}
	public int getHealthGrade() {
		return healthGrade;
	}
	public void setHealthGrade(int healthGrade) {
		this.healthGrade = healthGrade;
	}
    

}
