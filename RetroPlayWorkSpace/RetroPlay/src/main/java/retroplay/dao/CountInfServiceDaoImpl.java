package retroplay.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Count_inf;

@Repository
public class CountInfServiceDaoImpl implements CountInfServiceDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Count_inf getCountInformation() throws Exception {
		Count_inf countInf = new Count_inf();
		try {
			String hql = "FROM Count_inf";
			Query query = entityManager.createQuery(hql);

			countInf = ((List<Count_inf>) query.getResultList()).get(0);

			// TO DO Logging
			return countInf;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public int setPlaylistCountInformation(Integer playlistCount) throws Exception {
		try {
			String hql = "UPDATE Count_inf SET playlist_count=:playlist_count";
			Query query = entityManager.createQuery(hql);
			query.setParameter("playlist_count", playlistCount);

			int res = query.executeUpdate();

			// TO DO Logging
			return res;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

}
