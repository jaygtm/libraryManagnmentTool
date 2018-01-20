package service.impl;

import java.util.Date;
import java.util.List;

import dao.ViewBalanceDAO;
import model.ViewBalanceModel;
import service.ViewBalanceService;

public class ViewBalanceServiceImp implements ViewBalanceService {
	
	public ViewBalanceDAO viewBalanceDAO;

	@Override
	public ViewBalanceModel getViewBalance(Integer studentId) {
		return viewBalanceDAO.getViewBalance(studentId);
	}

	public ViewBalanceDAO getViewBalanceDAO() {
		return viewBalanceDAO;
	}

	public void setViewBalanceDAO(ViewBalanceDAO viewBalanceDAO) {
		this.viewBalanceDAO = viewBalanceDAO;
	}

	@Override
	public List getTxnhistoryList(Date fromDate, Date toDate){
		return viewBalanceDAO.getTxnhistoryList(fromDate, toDate);
	}


}
