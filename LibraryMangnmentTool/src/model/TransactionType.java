package model;

public enum TransactionType {
	Deposit{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Deposit";
		}
	},Withdrawal{
		@Override
		public String toString() {
			return "Withdrawal";
		}
	}
}
