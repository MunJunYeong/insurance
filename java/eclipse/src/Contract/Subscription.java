package Contract;

public class Subscription {
	private Long userIdx;
	private String insuranceType;
	private int fee;
	private int period;
	int maxReward;

	private boolean check = false;

	public Subscription(long userIdx, String insuranceType, int period, int maxReward) {
		this.userIdx = userIdx;
		this.insuranceType = insuranceType;
		//this.fee = fee;
		this.period = period;
		this.maxReward = maxReward;
	}

	public boolean matchId(long userIdx) {
		return this.userIdx.equals(userIdx);
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String toStringAll() {
		String stringReturn = this.userIdx + " " + this.insuranceType + " " + this.period + " " + this.fee + " "
				+ this.maxReward;
		return stringReturn;
	}

	public String toString() {
		String stringReturn = this.insuranceType + " " + this.period + " " + this.maxReward;
		return stringReturn;
	}

	public String getType() {
		return this.insuranceType;
	}

	public int getFee() {
		// TODO Auto-generated method stub
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Long getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(Long userIdx) {
		this.userIdx = userIdx;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getMaxReward() {
		return maxReward;
	}

	public void setMaxReward(int maxReward) {
		this.maxReward = maxReward;
	}

}