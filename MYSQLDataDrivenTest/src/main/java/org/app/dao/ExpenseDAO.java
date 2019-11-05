package org.app.dao;

import java.util.List;

import org.app.dto.Expense;

public interface ExpenseDAO {
	
	List<Expense> List();
	boolean create(Expense expens);
	boolean deleted(int id);
	boolean update(Expense expense);

}
