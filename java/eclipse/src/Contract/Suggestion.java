package Contract;

public class Suggestion {
	private Long userIdx;

	private String insuranceType;
	private String content;

	private boolean check = false;

	public Suggestion(long userIdx, String insuranceType, String content) {
		this.userIdx = userIdx;
		this.insuranceType = insuranceType;
		this.content = content;
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
		String stringReturn = this.userIdx + " " + this.insuranceType + " " + this.content;
		return stringReturn;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}