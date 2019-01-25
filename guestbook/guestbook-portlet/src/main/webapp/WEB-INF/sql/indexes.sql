create index IX_7AD77D1C on guestbook_Entry (groupId, guestbookId);
create index IX_DDC4E002 on guestbook_Entry (groupId, guestbookId, status);
create index IX_EB54165A on guestbook_Entry (uuid_);
create index IX_4E50518E on guestbook_Entry (uuid_, companyId);
create unique index IX_673BE390 on guestbook_Entry (uuid_, groupId);

create index IX_8D98E7DA on guestbook_Foo (field2);
create index IX_9E187006 on guestbook_Foo (uuid_);
create index IX_E6E57462 on guestbook_Foo (uuid_, companyId);
create unique index IX_3AA3AB64 on guestbook_Foo (uuid_, groupId);

create index IX_54428521 on guestbook_Guestbook (groupId);
create index IX_6DD2B820 on guestbook_Guestbook (groupId, name);
create index IX_24FE1307 on guestbook_Guestbook (groupId, status);
create index IX_DAC8EBEB on guestbook_Guestbook (uuid_);
create index IX_1893075D on guestbook_Guestbook (uuid_, companyId);
create unique index IX_12FFC11F on guestbook_Guestbook (uuid_, groupId);

create index IX_41146196 on rm_Entry (groupId);
create index IX_588D7D16 on rm_Entry (groupId, guestbookId);
create index IX_2BE045FC on rm_Entry (groupId, guestbookId, status);
create index IX_ABE161A0 on rm_Entry (uuid_);
create index IX_C9A95E88 on rm_Entry (uuid_, companyId);
create unique index IX_4587E70A on rm_Entry (uuid_, groupId);

create index IX_A15FC3E7 on rm_Guestbook (groupId);
create index IX_5D9B4A66 on rm_Guestbook (groupId, name);
create index IX_44EB2BCD on rm_Guestbook (groupId, status);
create index IX_B1932431 on rm_Guestbook (uuid_);
create index IX_F6490757 on rm_Guestbook (uuid_, companyId);
create unique index IX_1C497799 on rm_Guestbook (uuid_, groupId);