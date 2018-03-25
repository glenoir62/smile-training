create table FAQ_Faq (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	question VARCHAR(75) null,
	answer VARCHAR(75) null
);