package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	String USER_NAME = "root";
	String PASSWORD = "";
	String DB_URL = "jdbc:mysql://localhost:3306/estatespringboot";

	@Override
	public List<BuildingEntity> findAll(String name) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Building WHERE 1 = 1");
		if (name != null && !name.equals("")) {
			sql.append(" AND name like '%" + name + "%' ");
		}
		
		List<BuildingEntity> BuilidngList = new ArrayList<BuildingEntity>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setNumOFStage(rs.getInt("numOfStage"));
				
				BuilidngList.add(buildingEntity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return BuilidngList;
	}

}
