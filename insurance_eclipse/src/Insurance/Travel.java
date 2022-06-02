package Insurance;

public class Travel extends Insurance {


    private Long insuranceIdx;
    private String country;
    private int period;
    
	public Travel(Long insuranceIdx, String country, int period) {
		super();
		this.insuranceIdx = insuranceIdx;
		this.country = country;
		this.period = period;
	}
	public Long getInsuranceIdx() {
		return insuranceIdx;
	}
	public void setInsuranceIdx(Long insuranceIdx) {
		this.insuranceIdx = insuranceIdx;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}

}
