package WindowBuilder.Test;

public class DBTest3VO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String joinday;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoinday() {
		return joinday;
	}
	public void setJoinday(String joinday) {
		this.joinday = joinday;
	}
	@Override
	public String toString() {
		return "DBTest3VO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", joinday=" + joinday
				+ "]";
	}
}
