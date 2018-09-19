package retroplay.dao;

import retroplay.models.Count_inf;

public interface CountInfServiceDao {
	
	public Count_inf  getCountInformation() throws Exception; 
	
	public int setPlaylistCountInformation(Integer playlistCount) throws Exception;
	
}
