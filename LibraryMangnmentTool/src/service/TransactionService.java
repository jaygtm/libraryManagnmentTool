package service;

import java.util.List;

import model.TransectionHistoryModel;

public interface TransactionService {

	public boolean saveTransection(TransectionHistoryModel model);
	
	public List<TransectionHistoryModel> getAllTransaction();
}
