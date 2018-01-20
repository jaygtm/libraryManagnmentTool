package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import common.service.Factory;
import dao.TransactionDao;
import model.TransectionHistoryModel;

public class TransactionDaoImp implements TransactionDao {

	@Override
	public boolean saveTransection(TransectionHistoryModel model) {
		Session session = Factory.sessionfactory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
		Serializable id= session.save(model);
		session.beginTransaction().commit();
		return true;
		}catch(Exception e){
			if(tx!=null)
				tx.rollback();
			return false;
		}finally{
			session.close();	
		}
	}

	@Override
	public List<TransectionHistoryModel> getAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
