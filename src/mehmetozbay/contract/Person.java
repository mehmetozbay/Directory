package mehmetozbay.contract;

public class Person {
	
	private int id;
	private String name;
	private String surName;
	private String tel;
	private String email;
	private String adress;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name, String surName, String tel, String email, String adress) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.tel = tel;
		this.email = email;
		this.adress = adress;
	}
	public Person(String name, String surName, String tel, String email, String adress) {
		super();
		this.name = name;
		this.surName = surName;
		this.tel = tel;
		this.email = email;
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
