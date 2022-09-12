package com.dto;


public class Ticket {
    private int id;
    private int expense;
    private int employeeId;
    private String employeeName;
    private String employeeType;
	private String status;
    private String reason;

    public Ticket(int id, int expense, int employeeId,String employeeName,String employeeType, String status, String reason) {
        this.id = id;
        this.expense = expense;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.status = status;
        this.reason = reason;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}
