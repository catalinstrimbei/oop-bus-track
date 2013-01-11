
CREATE TABLE elemente_facturabile 
    ( 
     cod INTEGER  NOT NULL , 
     denumire VARCHAR2 (50 CHAR)  NOT NULL , 
     proc_tva_crt NUMBER (6,4)  NOT NULL , 
     grupa VARCHAR2 (40 CHAR)  NOT NULL , 
     UM VARCHAR2 (30 CHAR) , 
     cantit_unitara NUMBER (10,3) , 
     UM_cantit_unit VARCHAR2 (30 CHAR) , 
     detalii_serviciu VARCHAR2 (100 CHAR) , 
     tarif_unic NUMBER (10,2) , 
     baza_calcul VARCHAR2 (50 CHAR) , 
     tarif_unitar NUMBER (9,2) 
    ) 
;



ALTER TABLE elemente_facturabile 
    ADD CONSTRAINT item__PK PRIMARY KEY ( cod ) ;



CREATE TABLE facturi 
    ( 
     id_fact INTEGER  NOT NULL , 
     nr_fact VARCHAR2 (15)  NOT NULL , 
     data_fact DATE  NOT NULL , 
     client VARCHAR2 (50)  NOT NULL , 
     obs VARCHAR2 (150) 
    ) 
;



ALTER TABLE facturi 
    ADD CONSTRAINT factura__PK PRIMARY KEY ( id_fact ) ;



CREATE TABLE grupe 
    ( 
     grupa VARCHAR2 (40 CHAR)  NOT NULL , 
     procent_tva_crt NUMBER (6,4)  NOT NULL , 
     grupa1 VARCHAR2 (40 CHAR)  NOT NULL 
    ) 
;



ALTER TABLE grupe 
    ADD CONSTRAINT grupa__PK PRIMARY KEY ( grupa ) ;



CREATE TABLE linii_facturi 
    ( 
     linie SMALLINT  NOT NULL , 
     cantitate NUMBER (10,3)  NOT NULL , 
     pret_unit NUMBER (10,2)  NOT NULL , 
     tva_linie NUMBER (9,2)  NOT NULL , 
     obs VARCHAR2 (50 CHAR) , 
     id_fact INTEGER  NOT NULL , 
     cod INTEGER  NOT NULL 
    ) 
;



ALTER TABLE linii_facturi 
    ADD CONSTRAINT item_facturat__PK PRIMARY KEY ( linie, id_fact ) ;




ALTER TABLE linii_facturi 
    ADD CONSTRAINT apare_in FOREIGN KEY 
    ( 
     cod
    ) 
    REFERENCES elemente_facturabile 
    ( 
     cod
    ) 
;


ALTER TABLE linii_facturi 
    ADD CONSTRAINT este_compusa FOREIGN KEY 
    ( 
     id_fact
    ) 
    REFERENCES facturi 
    ( 
     id_fact
    ) 
;


ALTER TABLE elemente_facturabile 
    ADD CONSTRAINT face_parte_din FOREIGN KEY 
    ( 
     grupa
    ) 
    REFERENCES grupe 
    ( 
     grupa
    ) 
;


alter table grupe 
    ADD CONSTRAINT face_grupa_parte_din FOREIGN KEY 
    ( 
     grupa1
    ) 
    REFERENCES grupe 
    ( 
     grupa
    ) 
    ON DELETE CASCADE 
;

