DROP TABLE product CASCADE constraints;
DROP TABLE container CASCADE constraints;
DROP TABLE badqualitycontainer CASCADE constraints;
DROP TABLE wrongproductcontainer CASCADE constraints;
DROP TABLE package CASCADE constraints;

CREATE TABLE product (
	productID		INTEGER			PRIMARY KEY,
	productName		VARCHAR2(100),
	productImage	VARCHAR2(100)
);

INSERT INTO product VALUES (0, 'null', 'null');


CREATE TABLE container (
	containerID		VARCHAR2(100)	PRIMARY KEY,
	productID		INTEGER,
	productAmount	INTEGER
);

ALTER TABLE container
	ADD CONSTRAINT fk_container_productID  FOREIGN KEY (productID)
		REFERENCES product (productID);


CREATE TABLE badqualitycontainer (
	badQualityContainerID	VARCHAR2(100)	PRIMARY KEY,
	productID				INTEGER,
	amount					INTEGER
);

ALTER TABLE badqualitycontainer
	ADD CONSTRAINT fk_badquality_productID  FOREIGN KEY (productID)
		REFERENCES product (productID);
		
		
CREATE TABLE wrongproductcontainer (
	wrongProductContainer	VARCHAR2(100)	PRIMARY KEY,
	productID				INTEGER,
	productAmount			INTEGER
);

ALTER TABLE wrongproductcontainer
	ADD CONSTRAINT fk_wrongproduct_productID  FOREIGN KEY (productID)
		REFERENCES product (productID);
		
		
CREATE TABLE package (
	packageID		VARCHAR2(100)	PRIMARY KEY,
	palletID		VARCHAR2(100),
	productID		INTEGER,
	productAmount	INTEGER,
	containerID		VARCHAR2(100)
);

ALTER TABLE package
	ADD CONSTRAINT fk_package_productID  FOREIGN KEY (productID)
		REFERENCES product (productID);

ALTER TABLE package
	ADD CONSTRAINT fk_package_containerID  FOREIGN KEY (containerID)
		REFERENCES container (containerID);