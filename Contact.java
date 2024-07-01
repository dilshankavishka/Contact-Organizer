class Contact{
	private String cusId;
	private String name;
	private String phoneNum;
	private String company;
	private double salary;
	private String birthday;
	
	Contact(String id ,String name , String phonum, String company, double salary, String birthday){
		this.cusId=id;
		this.name=name;
		this.phoneNum=phonum;
		this.company=company;
		this.salary=salary;
		this.birthday=birthday;
	}
	public void set(Contact copy){
		this.cusId=copy.cusId;
		this.name=copy.name;
		this.phoneNum=copy.phoneNum;
		this.company=copy.company;
		this.salary=copy.salary;
		this.birthday=copy.birthday;
	}
	//-------------------S E T T E R S--------------------
	public void setcusId(String id){
		this.cusId=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setNumber(String number){
		this.phoneNum=number;
	}
	public void setCompany(String company){
		this.company=company;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	//--------------------G E T T E R S--------------------
	public String getcusId(){
		return cusId;
	}
	public String getName(){
		return name;
	}
	public String getNumber(){
		return phoneNum;
	}
	public String getCompany(){
		return company;
	}
	public double getSalary(){
		return salary;
	}
	public String getBirthday(){
		return birthday;
	}
}
