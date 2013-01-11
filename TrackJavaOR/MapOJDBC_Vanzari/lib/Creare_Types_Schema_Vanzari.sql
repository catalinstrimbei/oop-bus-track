drop table ElementFacturabil_Table
/
drop type Produs_type
/
drop type Elementfacturabil_type
/
--
create type ELEMENTFACTURABIL_TYPE as object 
  (cod number, denumire varchar2(30), proctvacrt number(4,2))
  NOT FINAL
/
create type PRODUS_TYPE under elementfacturabil_type 
  (um varchar2(30), cantitunitara number(30), umcantitunit varchar2(30))
/
--
create table ElementFacturabil_Table of elementfacturabil_type
/
--
insert into Elementfacturabil_Table values (Elementfacturabil_type(1, 'EL1', .24))
/
insert into elementfacturabil_table values (produs_type(2, 'PR1', .24, 'bc', 1, 'kg'))
/

select VALUE(p) from elementfacturabil_table p
/