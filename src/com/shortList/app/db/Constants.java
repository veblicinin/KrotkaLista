package com.shortList.app.db;

public class Constants {
	public static final String DATABASE_NAME = "shortList";
	protected static final int DATABASE_VERSION = 1;
	public static final String KEY_USER_NAME = "name";
	public static final int KEY_USER_NAME_POSITION = 1;
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_EVENT_ID = "event_id";
	public static final String KEY_PAYMENT_CASH = "cash";
	public static final String KEY_PAYMENT_DATE = "date";
	public static final String KEY_PAYMENT_DESCRIPTION = "description";
	public static final String KEY_PAYMENT_PAYER = "payer"; 
	
	public static final String KEY_DEBTOR_PAYMENT_ID = "payment_id";
	public static final String KEY_DEBTOR_DEBTOR_ID = "debtor_id";
	public static final String KEY_DEBTOR_EVENT_ID = "event_id";
	//public static final String KEY_DEBTOR_ = "";
	
	public static final String DATABASE_TABLE_PERSON = "person";
	public static final String DATABASE_TABLE_EVENT = "event";
	public static final String DATABASE_TABLE_PAYMENT = "payment";
	public static final String DATABASE_TABLE_DEBTOR = "debtor";
	public static final String DATABASE_TABLE_EVENT_PAYMENTS = "event_payments";
	
	
	
	protected static final String CREATE_TABLE_PERSON = "create table if not exists " + DATABASE_TABLE_PERSON + 
	" ("+ KEY_ROWID 	+ " integer primary key autoincrement, " + 
	KEY_EVENT_ID + " long not null, " + KEY_USER_NAME + " text not null " +
	")";
	
	protected static final String CREATE_TABLE_EVENT = "create table if not exists " + DATABASE_TABLE_EVENT + 
	" ("+ KEY_ROWID + " integer primary key autoincrement, " + 
	KEY_EVENT_ID + " long " +
	")";
	
	protected static final String CREATE_TABLE_PAYMENT = "create table if not exists " + DATABASE_TABLE_PAYMENT + 
	" ("+ KEY_ROWID 	+ " integer primary key autoincrement, " +  
	KEY_EVENT_ID + " long not null, " +
	KEY_PAYMENT_CASH + " float not null, " + KEY_PAYMENT_DATE + " long not null, " +
	KEY_PAYMENT_DESCRIPTION + " text, " + KEY_PAYMENT_PAYER + " long not null" +
	")";
	
	protected static final String CREATE_TABLE_DEBTOR = "create table if not exists " + DATABASE_TABLE_DEBTOR + 
	" ("+ KEY_ROWID 	+ " integer primary key autoincrement, " +  
	KEY_DEBTOR_DEBTOR_ID + " long not null, " + KEY_DEBTOR_EVENT_ID + " long not null, " +
	KEY_DEBTOR_PAYMENT_ID + " long not null " +
	")";
	 
}
