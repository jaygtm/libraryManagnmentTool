package service;

import java.util.Date;
import java.util.List;

import model.TransectionHistoryModel;
import model.ViewBalanceModel;

public interface ViewBalanceService {
	public ViewBalanceModel getViewBalance(Integer studentId);
	List<TransectionHistoryModel> getTxnhistoryList(Date fromDate, Date toDate);
}
