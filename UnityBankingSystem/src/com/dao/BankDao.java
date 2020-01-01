package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.AccountModel;
import com.model.AdminLogin;

//import org.graalvm.compiler.lir.amd64.AMD64Unary.RMOp;

import com.model.Application;
import com.model.Beneficiary;
import com.model.Branch;
import com.model.NetBankingprofile;
import com.model.Net_login;
import com.model.Transaction;

import oracle.jdbc.util.Login;
public class BankDao {
Connection con;
PreparedStatement ps,ps1;
public Connection getConnection() {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}


//getTansactionTable

public List<Transaction> getTansactionTable(String account_no){
	Connection con =getConnection();
	System.out.println(account_no);
	List<Transaction> lst = new ArrayList<Transaction>();
	try {
		System.out.println("errr1");
		ps=con.prepareStatement("select * from transaction where from_account=?");
		//where from_account=?
		System.out.println("errr2");
		ps.setString(1, account_no);
		ResultSet rs1= ps.executeQuery();
		while(rs1.next()) {
			System.out.println("inside searching all applicants");
			Transaction accm=new Transaction();
			accm.setTransation_id(rs1.getString(1));
			accm.setFrom_account(rs1.getString(2));
			accm.setTo_account(rs1.getString(3));
			accm.setTransactionType(rs1.getString(4));
			accm.setTransactionDate(rs1.getString(5));
			accm.setTranactionStatus(rs1.getString(6));
			
			lst.add(accm);
			con.close();
			
		}
		con.close();
		}	
		catch(SQLException e)
		{
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
			
		}
		return lst;
}





public String getAccBal(String bnf_accountno) {
	Connection con =getConnection();
	
	String bal="not set yet";
	//String bl="blanck";
	try {
		//System.out.println("Searching Branch in Banck Dao");
		ps=con.prepareStatement("select account_balance from account where account_no =?");
		//.out.println("Created con statement ps for searching branch in bank dao");
		ps.setString(1, bnf_accountno);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			bal=rs1.getString(1);
		}
		con.close();
		
		
	}catch (SQLException e) {
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
	
	System.out.println(bal);

	
	return bal;
	
}







//bnf_accountno

public String bnf_accountno(String b_id) {
	Connection con =getConnection();
	String account_no="not set yet";
	
	try {
		//System.out.println("Searching account_no in bankdao");
		ps=con.prepareStatement("select to_account from beneficiary where b_id =?");
		//System.out.println("Created con statement ps for searching email in bank dao");
		ps.setString(1, b_id);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			account_no=rs1.getString(1);
		}
		con.close();	
}catch (SQLException e) {
	System.out.println("Not found");
	System.err.print(e.getMessage());
	e.printStackTrace();
}
	System.out.println(account_no);
	return account_no;
	
}

public List<AccountModel> getAllAccountdetails(String account_no){
	Connection con =getConnection();
	List<AccountModel> l1 = new ArrayList<AccountModel>();
	try {
		System.out.println("errr1");
		ps=con.prepareStatement("select * from account where account_no=?");
		System.out.println("errr2");
		ps.setString(1, account_no);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println("inside searching all applicants");
			AccountModel accm=new AccountModel();
			accm.setAccount_no(rs.getString(1));
			accm.setAccount_balance(rs.getString(2));
			accm.setCust_id(rs.getString(3));
			accm.setBranch_name(rs.getString(4));
			accm.setBranch_code(rs.getString(5));
			accm.setIfsc_code(rs.getString(6));
			accm.setMicr_code(rs.getString(7));
			accm.setAccount_type(rs.getString(8));
			l1.add(accm);
			//con.close();
			
		}
		con.close();
		}	
		catch(SQLException e)
		{
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
			
		}
		return l1;


	
}

public String account_noFromUsername(String user_name) {
	Connection con =getConnection();
	String account_no="not set yet";
	
	try {
		System.out.println("Searching account_no in bankdao");
		ps=con.prepareStatement("select account_no from netbanking where username =?");
		System.out.println("Created con statement ps for searching email in bank dao");
		ps.setString(1, user_name);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			account_no=rs1.getString(1);
		}
		con.close();	
}catch (SQLException e) {
	System.out.println("Not found");
	System.err.print(e.getMessage());
	e.printStackTrace();
}
	System.out.println(account_no);
	return account_no;
	
}

public boolean validatenetBankingLogin(List<Net_login> list) {
	getConnection();
	boolean b=false;
	Net_login netlogin=(Net_login)list.get(0);
	try
	{
		ps=con.prepareStatement("select username,password from netbanking where username=? AND password=?");
		ps.setString(1,netlogin.getNet_username());
		ps.setString(2,netlogin.getNet_password());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			System.out.println("result set net banking login");
			b=true;
			
		}
		else
		{
			System.out.println("no result set for net banking login");
		}
		//con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	return b;
	 
}

///checkAccountExists


public boolean checkAccountExists(String ifsc,String acc_no){
	getConnection();
	boolean b=false;
	
	try
	{
		ps=con.prepareStatement("select ifsc_code from account where account_no=? AND ifsc_code=?");
		ps.setString(1,acc_no);
		ps.setString(2,ifsc);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			System.out.println("result set");
			b=true;
			
		}
		else
		{
			System.out.println("hii");
			System.out.println("no result..");
		}
		//con.close();
	}
	catch(SQLException e) {
		
		System.err.print(e.getMessage());
		e.printStackTrace();	}
	return b;
}


public boolean validate(List<AdminLogin> lst){
	getConnection();
	boolean b=false;
	AdminLogin ad=(AdminLogin)lst.get(0);
	try
	{
		ps=con.prepareStatement("select * from pass where uname=? AND pass=?");
		ps.setString(1,ad.getUname());
		ps.setString(2,ad.getPass());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			System.out.println("result set");
			b=true;
			
		}
		else
		{
			System.out.println("no result..");
		}
		//con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	return b;
}


//updatebaltransaction

public int updatebaltransaction(int up_balance, String currAccount) {
	Connection con =getConnection();
	int i=0;
	try {
		//String mail=email;
		ps=con.prepareStatement("update account set account_balance=? where account_no=?");
		//ps.setString(1, mail);
		ps.setInt(1, up_balance);
		ps.setString(2, currAccount);
		i=ps.executeUpdate();
		System.out.println("Balance Updated");
		con.close();
	}catch (SQLException e) {
		
		System.err.print(e.getMessage());;
		e.printStackTrace();
	}
	return i;
}



public int updateEmailApproval(String email) {
	Connection con =getConnection();
	int i=0;
	try {
		String mail=email;
		ps=con.prepareStatement("update application set IS_MAIL_VERIFIED=1 where email=?");
		ps.setString(1, mail);
		i=ps.executeUpdate();
		con.close();
	}catch (SQLException e) {
		
		System.err.print(e.getMessage());;
		e.printStackTrace();
	}
	return i;
}


public int updateApproval(String cust_id) {
	Connection con =getConnection();
	int i=0;
	try {
		int tempcust= Integer.parseInt(cust_id);
		ps=con.prepareStatement("update application set ISVERIFIED=1 where cust_id=?");
		ps.setInt(1, tempcust);
		i=ps.executeUpdate();
		con.close();
	}catch (SQLException e) {
		
		System.err.print(e.getMessage());;
		e.printStackTrace();
	}
	return i;
}



public int CreateBeneficiary(List<Beneficiary>listnet) {
	
	int i=0;
	Beneficiary beneficiary = listnet.get(0);
	Connection con =getConnection();
	try {
		ps=con.prepareStatement("insert into beneficiary values(bnf_seq.nextval,?,?,?,?,?)");
		ps.setString(1,beneficiary.getB_name());
		ps.setString(2,beneficiary.getFrom_account());
		ps.setString(3,beneficiary.getTo_account());
		ps.setString(4,beneficiary.getTo_ifsc());
		ps.setString(5,beneficiary.getB_limit());
	
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
	} catch (SQLException e) {
		System.err.print(e.getMessage());
		e.printStackTrace();
	}
			
	return i;
}



public int CreateNetBanking(List<NetBankingprofile>listnet) {
	
	int i=0;
	NetBankingprofile bankingprofile = listnet.get(0);
	Connection con =getConnection();
	try {
		ps=con.prepareStatement("insert into netbanking values(?,?,?)");
		ps.setString(1,bankingprofile.getAccount_number());
		ps.setString(2,bankingprofile.getUser_id());
		ps.setString(3,bankingprofile.getPassword());
	
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
	} catch (SQLException e) {
		System.err.print(e.getMessage());
		e.printStackTrace();
	}
			
	return i;
}

public int addVerifiedAccount(List<AccountModel> listAccount) {
	int i=0;
	AccountModel accountModel = listAccount.get(0);
	Connection con =getConnection();
	try {
		ps=con.prepareStatement("insert into account values(acc_seq.nextval,?,?,?,?,?,?,?)");
		ps.setString(1,accountModel.getAccount_balance());
		ps.setString(2,accountModel.getCust_id());
		ps.setString(3,accountModel.getBranch_name());
		ps.setString(4,accountModel.getBranch_code());
		ps.setString(5,accountModel.getIfsc_code());
		ps.setString(6,accountModel.getMicr_code());
		ps.setString(7,accountModel.getAccount_type());
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
	} catch (SQLException e) {
		System.err.print(e.getMessage());
		e.printStackTrace();
	}
			
	return i;
}


public int insertIntoTransaction(List<Transaction> lst1){
	Transaction r=lst1.get(0);
	Connection con =getConnection();
	System.out.println("test1"+con);
	int i=0;
	
	try {
		ps=con.prepareStatement("insert into transaction values(seq_transaction.nextval,?,?,?,sysdate,?)");
		//ps1=con.prepareStatement("insert into account values(acc_seq.nextval,500,,?,?,null,null,?)");
		int j=1;
		ps.setString(1, r.getFrom_account());
		ps.setString(2, r.getTo_account());
		ps.setString(3, r.getTransactionType());
		
		ps.setString(4, r.getTranactionStatus());
		
		
		
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
		
		

	} catch (SQLException e) {
		
		System.err.print(e.getMessage());
		e.printStackTrace();
	}
	return i;
}






public int savedData(List<Application> lst1){
	Application r=lst1.get(0);
	Connection con =getConnection();
	System.out.println("test1"+con);
	int i=0;
	
	try {
		ps=con.prepareStatement("insert into application values(seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0)");
		//ps1=con.prepareStatement("insert into account values(acc_seq.nextval,500,,?,?,null,null,?)");
		int j=1;
		ps.setString(1, r.getBranch_number());
		ps.setString(2, r.getAccount_type());
		ps.setString(3, r.getLast_name());
		ps.setString(4, r.getFirst_name());
		ps.setString(5, r.getMiddle_name());
		ps.setString(6, r.getBirth_date());
		
		ps.setString(7, r.getEmail_address());
		ps.setString(8, r.getMobile_number());		
		ps.setString(9, r.getNationality());
		ps.setString(10, r.getOccupation());
		ps.setString(11, r.getCity());
		ps.setString(12, r.getState());
		ps.setString(13, r.getDistrict());
		ps.setString(14, r.getPin_code());
		ps.setString(15, r.getAadhar_number());
		ps.setString(16, r.getPan_number());
		
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
		
		

	} catch (SQLException e) {
		
		System.err.print(e.getMessage());
		e.printStackTrace();
	}
	return i;
}


public String searchEmailType(String cust_id) {
	Connection con =getConnection();
	String emailset="not set yet";
	
	try {
		System.out.println("Searching email in Banck Dao");
		ps=con.prepareStatement("select email from application where cust_id =?");
		System.out.println("Created con statement ps for searching email in bank dao");
		ps.setString(1, cust_id);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
		emailset=rs1.getString(1);
		}
		con.close();	
}catch (SQLException e) {
	System.out.println("Not found");
	System.err.print(e.getMessage());
	e.printStackTrace();
}
	System.out.println(emailset);
	return emailset;
	
	}

public String getCustIDFromAccount(String account_no) {
	Connection con = getConnection();
	String cust_id ="account does not exist";
	try {
		System.out.println("Searching Branch1 in Banck Dao");
		ps=con.prepareStatement("select cust_id from account where account_no  =?");
		System.out.println("Created con statement ps for searching account_type in bank dao");
		ps.setString(1, account_no);
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
		cust_id=rs1.getString(1);
		}
		con.close();
	} catch (SQLException e) {
		System.out.println("Not found");
		System.err.print(e.getMessage());;
		e.printStackTrace();	
	}
	return cust_id;
	
}	

public String searchAccountType(String cust_id) {
	Connection con =getConnection();
	String account_type="not set yet";
	
	try {
		System.out.println("Searching Branch1 in Banck Dao");
		ps=con.prepareStatement("select account_type from application where cust_id =?");
		System.out.println("Created con statement ps for searching account_type in bank dao");
		ps.setString(1, cust_id);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
		account_type=rs1.getString(1);
		}
		con.close();	
}catch (SQLException e) {
	System.out.println("Not found");
	System.err.print(e.getMessage());
	e.printStackTrace();
}
	System.out.println(account_type);
	return account_type;
	
	}
public String searchBranch(String cust_id) {
	Connection con =getConnection();
	String br_name="not set yet";
	String bl="blanck";
	try {
		System.out.println("Searching Branch in Banck Dao");
		ps=con.prepareStatement("select branch_name from application where cust_id =?");
		System.out.println("Created con statement ps for searching branch in bank dao");
		ps.setString(1, cust_id);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
		br_name=rs1.getString(1);
		}
		con.close();
		
		
	}catch (SQLException e) {
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
	
	System.out.println(br_name);
	return br_name;
	
}
public List<Branch> searchBranchDetails(String br_name){
	Connection con=getConnection();
	List<Branch> list_branch = new ArrayList<Branch>();
	try {
		System.out.println("Inside Searching Branch List Bank Dao");
		ps=con.prepareStatement("select * from branch where branch_name=?");
		ps.setString(1, br_name);
		System.out.println("saved a statement for seaching list bank dao");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		System.out.println("inside while br_list_rs.next");
			Branch branch_object=new Branch();
			branch_object.setIfsc_code(rs.getString(1));
			branch_object.setBranch_name(rs.getString(2));
			branch_object.setBranch_code(rs.getString(3));
			branch_object.setMicr_code(rs.getString(4));
			//System.out.println(rs.getString(4));
			list_branch.add(branch_object);
			System.out.println(list_branch);
			
			//con.commit();
			//con.close();
			
		}
		con.close();
	}catch (SQLException e) {
		System.out.println("Not found");
		System.err.print(e.getMessage());
		e.printStackTrace();
		
	}
	return list_branch;
} 

public String accessAccount(String cust_id) {
	Connection con =getConnection();
	
	String acc_no="not set yet";
	//String bl="blanck";
	try {
		System.out.println("Searching Branch in Banck Dao");
		ps=con.prepareStatement("select account_no from account where cust_id =?");
		System.out.println("Created con statement ps for searching branch in bank dao");
		ps.setString(1, cust_id);
		
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			acc_no=rs1.getString(1);
		}
		con.close();
		
		
	}catch (SQLException e) {
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
	
	System.out.println(acc_no);

	
	return acc_no;
	
}

	//searchdataBnf


public List<Beneficiary> searchdataBnf(String acc_no){
	Connection con =getConnection();
	List<Beneficiary> l1 = new ArrayList<Beneficiary>();
	try {
		System.out.println("errr1");
		ps=con.prepareStatement("select * from beneficiary where from_account=?");
		System.out.println("errr2");
		ps.setString(1, acc_no);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println("inside searching all BNFS");
			Beneficiary beneficiary=new Beneficiary();
			beneficiary.setB_id(rs.getString(1));
			beneficiary.setB_name(rs.getString(2));
			beneficiary.setFrom_account(rs.getString(3));
			beneficiary.setTo_account(rs.getString(4));
			beneficiary.setTo_ifsc(rs.getString(5));
			beneficiary.setB_limit(rs.getString(6));
			
			l1.add(beneficiary);
			//con.close();
			
		}
		con.close();
		}	
		catch(SQLException e)
		{
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
			
		}
	return l1;
	
}





public List<Application> searchData(){
	Connection con =getConnection();
	List<Application> l1 = new ArrayList<Application>();
	try {
		System.out.println("errr1");
		ps=con.prepareStatement("select * from application where ISVERIFIED=0 and is_mail_verified=1" );
		System.out.println("errr2");
		//ps.setString(1, sno);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println("inside searching all applicants");
			Application apl=new Application();
			apl.setCust_id(rs.getString(1));
			apl.setBranch_number(rs.getString(2));
			apl.setAccount_type(rs.getString(3));
			apl.setLast_name(rs.getString(4));
			apl.setFirst_name(rs.getString(5));
			apl.setMiddle_name(rs.getString(6));
			apl.setBirth_date(rs.getString(7));
			apl.setEmail_address(rs.getString(8));
			apl.setMobile_number(rs.getString(9));
			apl.setNationality(rs.getString(10));
			apl.setOccupation(rs.getString(11));
			apl.setCity(rs.getString(12));
			apl.setState(rs.getString(13));
			apl.setDistrict(rs.getString(14));
			apl.setPin_code(rs.getString(15));
			apl.setAadhar_number(rs.getString(16));
			apl.setPan_number(rs.getString(17));
			l1.add(apl);
			//con.close();
			
		}
		con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Not found");
			System.err.print(e.getMessage());
			e.printStackTrace();
			
		}
		return l1;

}
}
