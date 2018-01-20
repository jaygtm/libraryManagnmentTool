package service.impl;

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

}
