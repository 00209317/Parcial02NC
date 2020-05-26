package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;

@Repository
public class CategoriaDAOimpl implements CategoriaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager categoriaManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = categoriaManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria>resulset=query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void save(Categoria c) throws DataAccessException {
		categoriaManager.persist(c);
		
	}

}
