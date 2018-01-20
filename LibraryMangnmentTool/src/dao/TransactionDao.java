package dao;

import java.util.List;

import model.TransectionHistoryModel;

public interface TransactionDao {
	
	public boolean saveTransection(TransectionHistoryModel model);
	
	public List<TransectionHistoryModel> getAllTransaction();

}
