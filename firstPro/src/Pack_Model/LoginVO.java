package Pack_Model;

public class LoginVO {
	private String u_id;
	private String u_pass;
	private String u_name;
	private String u_gender;
	private String u_birth;
	private String u_pno;

	// 생성자
	public LoginVO() {
	}

	// Setter and Getter
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public void setU_pno(String u_pno) {
		this.u_pno = u_pno;
	}

	public String getU_id() {
		return u_id;
	}

	public String getU_pass() {
		return u_pass;
	}

	public String getU_name() {
		return u_name;
	}

	public String getU_gender() {
		return u_gender;
	}

	public String getU_birth() {
		return u_birth;
	}

	public String getU_pno() {
		return u_pno;
	}
}
