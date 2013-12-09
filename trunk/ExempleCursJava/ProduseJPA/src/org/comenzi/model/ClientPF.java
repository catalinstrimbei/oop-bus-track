package org.comenzi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;


@Entity
public class ClientPF extends Client{
	@Temporal(DATE)
	Date dataNastere;
}
