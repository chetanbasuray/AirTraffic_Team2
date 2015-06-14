/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;
import java.util.List;

/**
 * @author JOY
 *
 */
public class MaintenanceTeamBean {
	private int maintenanceteam_id;
	private Date maintenance_startworkingtime;
	private Date maintenance_endworkingtime;
	private List<EmployeeBean> employeeList;  
	
	
	public int getMaintenanceteam_id() {
		return maintenanceteam_id;
	}
	public void setMaintenanceteam_id(int maintenanceteam_id) {
		this.maintenanceteam_id = maintenanceteam_id;
	}
	public Date getMaintenance_startworkingtime() {
		return maintenance_startworkingtime;
	}
	public void setMaintenance_startworkingtime(Date maintenance_startworkingtime) {
		this.maintenance_startworkingtime = maintenance_startworkingtime;
	}
	public Date getMaintenance_endworkingtime() {
		return maintenance_endworkingtime;
	}
	public void setMaintenance_endworkingtime(Date maintenance_endworkingtime) {
		this.maintenance_endworkingtime = maintenance_endworkingtime;
	}
	public List<EmployeeBean> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeBean> employeeList) {
		this.employeeList = employeeList;
	}
}