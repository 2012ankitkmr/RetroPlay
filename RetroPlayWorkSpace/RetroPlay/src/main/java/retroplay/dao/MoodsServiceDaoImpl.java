package retroplay.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Moods;

@Repository
public class MoodsServiceDaoImpl implements MoodsServiceDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	// Fetches Mood List from Database
	@SuppressWarnings("unchecked")
	@Override
	public List<Moods> getAllMoods() throws Exception {
		List<Moods> result = new ArrayList<Moods>();
		try {
			String hql = "FROM Moods";
			Query query = entityManager.createQuery(hql);
			result = (List<Moods>) query.getResultList();
			// TO DO Logging
			return result;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
}
