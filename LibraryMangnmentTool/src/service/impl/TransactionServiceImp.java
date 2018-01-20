package service.impl;

import java.util.List;

import dao.TransactionDao;
import model.TransectionHistoryModel;
import service.TransactionService;

public class TransactionServiceImp implements TransactionService {

	TransactionDao transactionDao;
	
	@Override
	public boolean saveTransection(TransectionHistoryModel model) {
		return transactionDao.saveTransection(model);
	}

	@Override
	public List<TransectionHistoryModel> getAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*****Setter And Getter ****/
	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

}
