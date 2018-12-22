create index IX_7AD77D1C on guestbook_Entry (groupId, guestbookId);
create index IX_EB54165A on guestbook_Entry (uuid_);
create index IX_4E50518E on guestbook_Entry (uuid_, companyId);
create unique index IX_673BE390 on guestbook_Entry (uuid_, groupId);

create index IX_8D98E7DA on guestbook_Foo (field2);
create index IX_9E187006 on guestbook_Foo (uuid_);
create index IX_E6E57462 on guestbook_Foo (uuid_, companyId);
create unique index IX_3AA3AB64 on guestbook_Foo (uuid_, groupId);

create index IX_54428521 on guestbook_Guestbook (groupId);
create index IX_DAC8EBEB on guestbook_Guestbook (uuid_);
create index IX_1893075D on guestbook_Guestbook (uuid_, companyId);
create unique index IX_12FFC11F on guestbook_Guestbook (uuid_, groupId);