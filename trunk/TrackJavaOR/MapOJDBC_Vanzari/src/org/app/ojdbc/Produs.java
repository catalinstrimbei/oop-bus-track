package org.app.ojdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Produs extends ElementFacturabil {
	private String um;
	
	private BigDecimal cantitUnitara;
	
	private String umCantitUnit;

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public BigDecimal getCantitUnitara() {
		return cantitUnitara;
	}

	public void setCantitUnitara(BigDecimal cantitUnitara) {
		this.cantitUnitara = cantitUnitara;
	}

	public String getUmCantitUnit() {
		return umCantitUnit;
	}

	public void setUmCantitUnit(String umCantitUnit) {
		this.umCantitUnit = umCantitUnit;
	}

	public Produs() {
		super();
	}

	public Produs(long cod, String denumire, BigDecimal procTvaCrt, String um,
			BigDecimal cantitUnitara, String umCantitUnit) {
		super(cod, denumire, procTvaCrt);
		this.um = um;
		this.cantitUnitara = cantitUnitara;
		this.umCantitUnit = umCantitUnit;
	}
	
	// SqlData implementation
	private String sql_type; 
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		super.readSQL (stream, typeName);    // read supertype attributes 
		
		sql_type = typeName; 
		this.um = stream.readString();
		this.cantitUnitara = stream.readBigDecimal();
		this.umCantitUnit = stream.readString();
		
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		super.writeSQL (stream);        // write supertype
		
		stream.writeString(this.um);
		stream.writeBigDecimal(this.cantitUnitara);
		stream.writeString(this.umCantitUnit);
	}		
}
