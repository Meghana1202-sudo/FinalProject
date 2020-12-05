package com.quinnox.sbiloans.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.sbiloans.dto.LoanType;

@Repository
public class LoanTypeDaoImpl implements LoanTypeDao {


	@Autowired
	EntityManager manager;
    
	@Transactional
	@Override
	public boolean addLoanType(LoanType Type) {
		manager.persist(Type);
		return true;
	}

	@Transactional
	@Override
	public boolean updateLoanType(LoanType Type) {
		LoanType type1 = manager.find(LoanType.class, Type.getId());
		BeanUtils.copyProperties(Type,type1 );
			return true;
	}

	@Override
	public List<LoanType> getAllLoanType() {
		TypedQuery<LoanType> query = manager.createQuery("from LoanType",LoanType.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public boolean deleteLoanType(int id) {
		LoanType type = manager.find(LoanType.class, id);
		manager.remove(type);
		return true;
	}
}
