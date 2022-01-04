package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;

import util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String username = rs.getString("e_username");
				String password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int man_id = rs.getInt("man_e_id");
				
				Employee newEmp = new Employee(id, name, username, password, role, man_id );
				employees.add(newEmp);
			}
			
			} catch (SQLException |IOException e) {
				e.printStackTrace();
			} 
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employees where e_id = ? ";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String username = rs.getString("e_username");
				String password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int man_id = rs.getInt("man_e_id");

				emp = new Employee(id1, name, username, password, role, man_id);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee resultId= null;
		String sql = "insert into employees (e_name, e_username, e_password, e_role) "
				+ "values (?, ?, ?, ?) returning e_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = employee;
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return resultId;
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employees where e_id = ?;";
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return rowsChanged;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		String sql = "update employees set e_name = ?, e_username = ?, e_password = ?, e_role = ?, man_e_id = ? "
				+ "where e_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());
			ps.setInt(5, employee.getManagerId());
			ps.setInt(6, employee.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}


}
