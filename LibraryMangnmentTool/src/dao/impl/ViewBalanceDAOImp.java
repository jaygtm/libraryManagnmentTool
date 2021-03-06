package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.service.Factory;
import dao.ViewBalanceDAO;
import model.TransectionHistoryModel;
import model.ViewBalanceModel;

public class ViewBalanceDAOImp implements ViewBalanceDAO {

	@Override
	public ViewBalanceModel getViewBalance(Integer studentId) {
		Session seession = Factory.sessionfactory.openSession();
		String query = "select c.customer_name,c.customer_balance ,sum(txn_charge)AS charge,"
						+ " sum(txn_item_late_submit_charge)As late_charge ,(Select sum(amount)As deposit"
						+ " from txn_amount_his where submited_by = c.customer_id and txn_type = 'D')AS deposit,"
						+ " (Select sum(amount)As deposit from txn_amount_his where submited_by = c.customer_id "
						+ " and txn_type = 'W')AS widhral from mst_customer c left join txn_item_his tx_h on "
						+ " c.customer_id = tx_h.customer_id where  c.customer_id = "+studentId+" group by c.customer_id";
		try {
			System.out.println(query);
			ViewBalanceModel model = new ViewBalanceModel();
			List list =  seession.createSQLQuery(query).list();
			if(!list.isEmpty()){
				Object[] objArr = (Object[]) list.get(0);
				model.setCustomer_name(objArr[0].toString());
				if(objArr[1] != null)
					model.setOpening_balance(Float.parseFloat(objArr[1].toString()));
				if(objArr[2] != null)
					model.setCharge(Float.parseFloat(objArr[2].toString()));
				if(objArr[3] != null)
					model.setLate_charge(Float.parseFloat(objArr[3].toString()));
				if(objArr[4] != null)
					model.setDeposit(Float.parseFloat(objArr[4].toString()));
				if(objArr[5] != null)
					model.setWidhral(Float.parseFloat(objArr[5].toString()));
			}
			
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransectionHistoryModel> getTxnhistoryList(Date fromDate, Date toDate) {
		List<TransectionHistoryModel> transectionHistoryObject=new ArrayList();
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(TransectionHistoryModel.class); 
			//c.add(Restrictions.between("txn_date", fromDate, toDate));
			c.add(Restrictions.ge("txn_date", Factory.getNextDate(fromDate))); 
			c.add(Restrictions.lt("txn_date", toDate));
			System.out.println(fromDate+"   "+Factory.getNextDate(toDate));
			transectionHistoryObject=c.list();  
		/*transectionHistoryObject = session.createSQLQuery("select idtxn_amount_his,txn_amount_his.submited_by,mst_customer.customer_name"
								+ " ,txn_amount_his.Recived_by,mst_user.user_name,txn_amount_his.txn_date ,"
								+ " txn_amount_his.txn_type, txn_amount_his.amount  "
								+ " from txn_amount_his"
								+ " inner join mst_customer on mst_customer.customer_id=txn_amount_his.submited_by "
								+ " inner join mst_user on mst_user.user_id=txn_amount_his.Recived_by "
								+ " where (txn_amount_his.txn_date BETWEEN '"+fromDate+"'AND '"+toDate+"') ").list();*/
			return transectionHistoryObject;
		}catch(Exception e){
			e.printStackTrace();
			return transectionHistoryObject;
		}finally{
			session.close();
		}
	}

}
