package com.luv2code.springboot.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class RoleDaoImpl implements RoleDao {

	private EntityManager entityManager;

	public RoleDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Role findRoleByName(String theRoleName) {
		// read from database using roleName
		TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName",Role.class);
		theQuery.setParameter("roleName", theRoleName);

		Role theRole = null;
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		return theRole;
	}

}
