package org.app.daoimpl;

import org.app.dao.ExpenseDAO;
import org.app.dto.Expense;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("expenseDAO")
@Transactional
public class ExpenseDAOImpl implements ExpenseDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	// get list of expenses
	@Override
	public java.util.List<Expense> List() {
		return sessionFactory.getCurrentSession().createQuery("FROM Expense", Expense.class).getResultList();
	}
	
	// Add expenses in account
	@Override
	public boolean create(Expense expense) {
		
		try {
			sessionFactory.getCurrentSession().save(expense);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// delete any recode from account
	@Override
	public boolean deleted(int id) {
		//HQL = "DELETE FROM Expense e WHERE e.di = :id"
		String SELECT_QUERY = "FROM Expense where id = :id";
		try {
			Expense  expense = sessionFactory.getCurrentSession().createQuery(SELECT_QUERY, Expense.class).setParameter("id", id).getSingleResult();
			sessionFactory.getCurrentSession().delete(expense);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	// update already exist data
	@Override
	public boolean update(Expense expense) {
		
		try {
			sessionFactory.getCurrentSession().update(expense);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		return false;
		}
	}

}
