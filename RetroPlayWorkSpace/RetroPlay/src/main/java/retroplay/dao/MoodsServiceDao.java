package retroplay.dao;

import java.util.List;

import retroplay.models.Moods;

public interface MoodsServiceDao {

	List<Moods> getAllMoods() throws Exception;
}
