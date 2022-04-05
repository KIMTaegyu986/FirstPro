package Pack_Player;

public class PlayerVO {
	private String p_no;
	private String t_code;
	private String p_backno;
	private String p_name;
	private String p_birth;
	private String p_length;
	private String p_weight;
	private String p_pos;

	public PlayerVO() {
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getT_code() {
		return t_code;
	}

	public void setT_code(String t_code) {
		this.t_code = t_code;
	}

	public String getP_backno() {
		return p_backno;
	}

	public void setP_backno(String p_backno) {
		this.p_backno = p_backno;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_birth() {
		return p_birth;
	}

	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}

	public String getP_length() {
		return p_length;
	}

	public void setP_length(String p_length) {
		this.p_length = p_length;
	}

	public String getP_weight() {
		return p_weight;
	}

	public void setP_weight(String p_weight) {
		this.p_weight = p_weight;
	}

	public String getP_pos() {
		return p_pos;
	}

	public void setP_pos(String p_pos) {
		this.p_pos = p_pos;
	}

	@Override
	public String toString() {
		return "PlayerVO [p_no=" + p_no + ", t_code=" + t_code + ", p_backno=" + p_backno + ", p_name=" + p_name
				+ ", p_birth=" + p_birth + ", p_length=" + p_length + ", p_weight=" + p_weight + ", p_pos=" + p_pos
				+ "]";
	}

}
