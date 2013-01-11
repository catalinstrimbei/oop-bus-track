package org.app.ojdbc;

import java.math.BigDecimal;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ElementFacturabil implements SQLData{
	
	private long cod;

	private String denumire;

	private BigDecimal procTvaCrt;

    public ElementFacturabil() {
    }

	public long getCod() {
		return this.cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public BigDecimal getProcTvaCrt() {
		return this.procTvaCrt;
	}

	public void setProcTvaCrt(BigDecimal procTvaCrt) {
		this.procTvaCrt = procTvaCrt;
	}

	public ElementFacturabil(long cod, String denumire, BigDecimal procTvaCrt) {
		super();
		this.cod = cod;
		this.denumire = denumire;
		this.procTvaCrt = procTvaCrt;
	}

	// SqlData implementation
	private String sql_type; 
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		sql_type = typeName; 
		this.cod = stream.readLong();
		this.denumire = stream.readString();
		this.procTvaCrt = stream.readBigDecimal();
		
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		stream.writeLong(this.cod);
		stream.writeString(this.denumire);
		stream.writeBigDecimal(this.procTvaCrt);
	}	
	
}