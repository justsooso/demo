package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestUpdateField {
	
	public static void main(String[] args) throws Exception {
		String url = "jdbc:postgresql://192.9.200.185:5432/dev";
		String username = "saas";
		String pwd = "inca";
		Connection conn = DriverManager.getConnection(url, username,
        		pwd);
        conn.setAutoCommit(false);
        Statement statement = conn.createStatement();
        String sql = "select * from ebs_vip_share limit 0";
        ResultSet res = statement.executeQuery(sql);
        ResultSetMetaData metaData = res.getMetaData();
        metaData.getColumnCount();
        String updateColumnName = "dept_id";
        for(int i=1; i < metaData.getColumnCount()+1; i++){
        	String columnName = metaData.getColumnName(i);
        	if(columnName.equalsIgnoreCase(updateColumnName)){
        		int columnType = metaData.getColumnType(i);
        		String columnTypeName = metaData.getColumnTypeName(i);
        		System.out.println(columnName);
        		System.out.println(columnType);
        		System.out.println(columnTypeName);
        		if(columnTypeName.equalsIgnoreCase("bytea")){
        			System.out.println("---------------");
        			String dropSql = " alter table ebs_vip_share drop column " + updateColumnName;
        			String updateSql = "ALTER TABLE ebs_vip_share ADD " + updateColumnName + " int4";
        			String updateSql2 = "alter table ebs_vip_share add constraint fk_pqeklmf9lerfgyn2bnlplx2y1 foreign key(" + updateColumnName + ") references pub_dept(id)";
        			statement.execute(dropSql);
        			statement.execute(updateSql);
        			statement.execute(updateSql2);
        			conn.commit();
        		}
        	}
        }
	}

}
