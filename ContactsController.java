import java.util.*;
import java.time.*;
import java.time.LocalDate;

class ContactsController{
	
	//public static  ArrayList<Contact>contactList=new ArrayList<>();;
	
	
	public static boolean isValidBirthday(String birthday){  //birthday check
        int year=Integer.parseInt(birthday.substring(0,4));
		int month=Integer.parseInt(birthday.substring(5,7));
		int day=Integer.parseInt(birthday.substring(8,10));
		
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
		}else if(year==currentYear){
									
			if(month>currentMonthValue){
				return true;
			}else if(month==currentMonthValue){
									
				if(day<=currentMonthDate){
					return true;
				}
			}
		}
			return false;
    }

	public static boolean phoneNumberCheck(String number){ //phone number check
		if(number.length()==10 && number.charAt(0)=='0'){
			 for(int i=1; i<number.length(); i++){
				if(!Character.isDigit(number.charAt(i))){
					return false;
				}
			}
		return true;
		}
		return false;
	}
	
	public static String generateId(){
		if(DBConnection.getInstance().getContactList().isEmpty()){
			return "C0001";
		}
		return String.format("C%04d",DBConnection.getInstance().getContactList().size()+1);
	}
	
	public static int  searchFunction(String input){
		int i=0;
		for(;i<DBConnection.getInstance().getContactList().size(); i++){
			if(DBConnection.getInstance().getContactList().get(i).getName().equals(input) || DBConnection.getInstance().getContactList().get(i).getNumber().equals(input)){
				return i;
			}
		}
		return -1;
	}

	public static Contact[] birthdaySort(){
		Contact[] temp =DBConnection.getInstance().getContactList().toArray(new Contact[0]);
		for(int i=DBConnection.getInstance().getContactList().size()-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(temp[j].getBirthday().compareTo(temp[j+1].getBirthday())>0){
					Contact tempContacts = temp[j];
					temp[j] = temp[j+1];
					temp[j+1]= tempContacts;
				}
			}
		}
		return temp;
	}
	
	public static Contact[] salarySort(){
		Contact[] temp =DBConnection.getInstance().getContactList().toArray(new Contact[0]);
		for(int i=DBConnection.getInstance().getContactList().size()-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(temp[j].getSalary()>temp[j+1].getSalary()){
					Contact tempContacts = temp[j];
					temp[j] = temp[j+1];
					temp[j+1]= tempContacts;
				}
			}
		}
		return temp;
	}
	
	public static Contact[] nameSort(){
		Contact[] temp =DBConnection.getInstance().getContactList().toArray(new Contact[0]);
		for(int i=DBConnection.getInstance().getContactList().size()-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(temp[j].getName().compareToIgnoreCase(temp[j+1].getName())>0){
					Contact tempContacts = temp[j];
					temp[j] = temp[j+1];
					temp[j+1]= tempContacts;
				}
			}
		}
		return temp;
	}
}
