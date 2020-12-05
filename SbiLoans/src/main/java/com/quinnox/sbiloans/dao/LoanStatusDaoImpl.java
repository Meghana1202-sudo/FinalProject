package com.quinnox.sbiloans.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.sbiloans.dto.LoanStatus;

@Repository
public class LoanStatusDaoImpl implements LoanStatusDao {
   
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addLoanStatusDetails(LoanStatus details) {
		manager.persist(details);
		return true;
	}

	@Override
	@Transactional
	public boolean updateLoanStatusDetails(LoanStatus bean) {
	
		LoanStatus loanstatusBean = manager.find(LoanStatus.class, bean.getId());
		if (bean.getApplicationId() != 0) {
			loanstatusBean.setApplicationId(bean.getApplicationId());
		} else {
			loanstatusBean.setApplicationId(loanstatusBean.getApplicationId());
		}
		if (bean.getLoanStatus() != null) {
			loanstatusBean.setLoanStatus(bean.getLoanStatus());
		} else {
			loanstatusBean.setLoanStatus(loanstatusBean.getLoanStatus());
		}
		return true;
	}

	@Override
	@Transactional
	public LoanStatus searchLoanStatus(int id) {
	
		LoanStatus bean = manager.find(LoanStatus.class, id);
	
		if (bean != null) {
			return bean;
		}
		return bean;
	}

	@Override
	@Transactional
	public List<LoanStatus> getAllLoanStatus() {
		String jpql = "from LoanStatus";
		Query query = manager.createQuery(jpql);
		List<LoanStatus> list = query.getResultList();
		return list;
	}

	
	



}
