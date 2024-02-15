package com.jsp.jdbc_crud_with_prepared_stateement.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;
public class ProductController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		try {
			//step-1
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String pass="root";
			connection = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("!!!Please enter your choice!!!");
		System.out.println("Press 1 ==> to INSERT Data");
		System.out.println("Press 2 ==> to UPDATE Data");
		System.out.println("Press 3 ==> to DELETE Data");
		System.out.println("Press 4 ==> to Display All Data");
		System.out.println("Press 5 ==> to Display By ID");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 :
		{
			System.out.println("-----You have selected INSERT Data-----");
			System.out.println("Enter name");
			String name=sc.next();
			name+=sc.nextLine();
			System.out.println("Enter price");
			double price=sc.nextDouble();
			System.out.println("Enter color");
			String color=sc.next();
			color+=sc.nextLine();
			System.out.println("Enter expiry date");
			System.out.println("Enter year");
			int year=sc.nextInt();
			System.out.println("Enter month");
			int month=sc.nextInt();
			System.out.println("Enter day");
			int day=sc.nextInt();
			LocalDate expiryDate=LocalDate.of(year, month, day);
			String insertQuery="insert into product(name,price,color,expirydate) values(?,?,?,?)";
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				
				preparedStatement.setString(1, name);
				preparedStatement.setDouble(2, price);
				preparedStatement.setString(3, color);
				preparedStatement.setObject(4, expiryDate);
				preparedStatement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Data inserted successfully!!!");
		
			break;
		}
		case 2 : {
			System.out.println("-----You have selected UPDATE data");
			System.out.println("Press 1 ==> to update name");
			System.out.println("Press 2 ==> to update color");
			System.out.println("Press 3 ==> to update price");
			System.out.println("Press 4 ==> to update expirydate");
			int choicee=sc.nextInt();
			switch(choicee)
			{
			case 1 : {
				System.out.println("----You have selected update name----");
				System.out.println("Enter id of which you want to update name");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				name+=sc.nextLine();
				String updateQuery="update product set name=? where id=?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
					int a =preparedStatement.executeUpdate();
					if(a!=0)
					{
						System.out.println("Data Updated Successfully!!!");
					}
					else
					{
						System.err.println("Data Not Updated!!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 2 : {
				System.out.println("----You have selected update color----");
				System.out.println("Enter id of which you want to update color");
				int id=sc.nextInt();
				System.out.println("Enter color");
				String color=sc.next();
				color+=sc.nextLine();
				String updateQuery="update product set color=? where id=?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
					preparedStatement.setString(1, color);
					preparedStatement.setInt(2, id);
					int a =preparedStatement.executeUpdate();
					if(a!=0)
					{
						System.out.println("Data Updated Successfully!!!");
					}
					else
					{
						System.err.println("Data Not Updated!!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 3: {
				System.out.println("----You have selected update price----");
				System.out.println("Enter id of which you want to update price");
				int id=sc.nextInt();
				System.out.println("Enter price");
				double price=sc.nextDouble();
				String updateQuery="update product set price=? where id=?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
					preparedStatement.setDouble(1, price);
					preparedStatement.setInt(2, id);
					int a =preparedStatement.executeUpdate();
					if(a!=0)
					{
						System.out.println("Data Updated Successfully!!!");
					}
					else
					{
						System.err.println("Data Not Updated!!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 4:{
				System.out.println("----You have selected update expiry date----");
				System.out.println("Enter id of which you want to update expiry date");
				int id=sc.nextInt();
				System.out.println("Enter expiry date");
				System.out.println("Enter year");
				int year=sc.nextInt();
				System.out.println("Enter month");
				int month=sc.nextInt();
				System.out.println("Enter day");
				int day=sc.nextInt();
				String updateQuery="update product set expirydate = ? where id = ?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
					preparedStatement.setObject(1, LocalDate.of(year, month, day));
					preparedStatement.setInt(2, id);
					int a =preparedStatement.executeUpdate();
					if(a!=0)
					{
						System.out.println("Data Updated Successfully!!!");
					}
					else
					{
						System.err.println("Data Not Updated!!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			}
			break;
		}
		case 3 :{
			System.out.println("----You have selected delete data----");
			System.out.println("Enter id of which you want to delete data");
			int id=sc.nextInt();
			String deleteQuery="delete from product where id = ?";
			try {
				PreparedStatement preparedStatement =connection.prepareStatement(deleteQuery);
				preparedStatement.setInt(1, id);
				int a=preparedStatement.executeUpdate();
				if(a!=0)
				{
					System.out.println("Data deleted successfully!!!");
				}
				else
				{
					System.err.println("Data Not deleted !!!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 4 : {
			System.out.println("----You have selected Display Data----");
			String displayQuery="select * from product";
			try {
				PreparedStatement preparedStatement =connection.prepareStatement(displayQuery);
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					int id=resultSet.getInt("id");
					System.out.println("Id ="+id);
					
					String name=resultSet.getString("name");
					System.out.println("Name ="+name);
					
					String color=resultSet.getString("color");
					System.out.println("Color = "+color);
					
					double price=resultSet.getDouble("price");
					System.out.println("Price = "+price);
					
					Object expirydate=resultSet.getObject("expirydate");
					System.out.println("Expiry Date = "+expirydate);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		case 5 : {
				System.out.println("----You have selected Display Data by ID----");
				System.out.println("Enter id of which you want to display data");
				int id=sc.nextInt();
				String displayQuery="select * from product where id=?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(displayQuery);
					preparedStatement.setInt(1, id);
					ResultSet resultSet =preparedStatement.executeQuery();
					if(resultSet.next()) {
						int id1=resultSet.getInt("id");
						System.out.println("Id = "+id1);
						String name=resultSet.getString("name");
						System.out.println("Name = "+name);
						String color=resultSet.getString("color");
						System.out.println("Color = "+color);
						double price=resultSet.getDouble("price");
						System.out.println("Price = "+price);
						Object expirydate=resultSet.getObject("expirydate");
						System.out.println("Expiry Date = "+expirydate);
					}else {
						System.err.println("Given id is not found");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;	
		}
			
		}
		
	}
}