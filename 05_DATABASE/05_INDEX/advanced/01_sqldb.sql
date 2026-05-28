use sqldb;

select *
from usertbl;

show index from usertbl;

show table status like 'usertbl';
-- data_length: 16384
-- index_length: 0


create index idx_usertbl_addr
on usertbl(addr);

show index from usertbl;

analyze table usertbl;  -- 통계 강제 갱신
show table status like 'usertbl';
-- data_length: 16384
-- index_length: 16384


create index idx_usertbl_birthYear
on usertbl(birthYear);

create index idx_usertbl_name
on usertbl(name);

show index from usertbl;


drop index idx_usertbl_name on usertbl;

create index idx_usertbl_name_birthYear
on usertbl(name, birthYear);

show index from usertbl;


drop index idx_usertbl_addr on usertbl;
drop index idx_usertbl_birthYear on usertbl;
drop index idx_usertbl_name_birthYear on usertbl;

show index from usertbl;