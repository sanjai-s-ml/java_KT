package com.example;
import java.util.*;
import java.sql.*;
public class CRUDJDBC {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite://home//Sanjai//Documents//univ.db");
        Statement stm=conn.createStatement();

        stm.executeUpdate("insert into students values(14,'sree','karur',10)");
        stm.executeUpdate("update students set deptno=10 where name='sanjay'");
        //Fetching through prepared statement
        PreparedStatement pstm=conn.prepareStatement("select * from students where deptno=?");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter dept no : ");
        int deptno=sc.nextInt();
        pstm.setInt(1,deptno);
        ResultSet rs=pstm.executeQuery();
        System.out.println("Students from deptno  "+ deptno);
        display(rs);

        stm.executeUpdate("update students set deptno=40 where name='sanjay'");
        stm.executeUpdate("delete from students where roll=14");
        rs=stm.executeQuery("select * from students");
        System.out.println();
        System.out.println("Students details ,");
        display(rs);

        stm.close();
        conn.close();
    }
    public static void display(ResultSet rs) throws SQLException{
        int roll;
        String name;
        String city;
        int deptno;
        while(rs.next()){
            roll=rs.getInt("roll");
            name=rs.getString("name");
            city=rs.getString("city");
            deptno=rs.getInt("deptno");
            System.out.println("Roll no : "+roll+" "+"Name : "+name+" "+"City : "+city+" "+"deptno : "+deptno);
        }
    }
}
