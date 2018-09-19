package retroplay.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retroplay.dao.MoodsServiceDao;
import retroplay.models.Moods;

@Service("moodsService")
@Transactional
public class MoodsServiceImpl implements MoodsService{

	@Autowired
	private MoodsServiceDao moodsServiceDao;

	// Returns Moods List 
	@Override
	public List<Moods>  getAllMoods() throws Exception {
		List<Moods> moodslist = new ArrayList<Moods>();
		try {
			moodslist = moodsServiceDao.getAllMoods();
			return moodslist;
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

}
