package org.model.subiecte.contabilitate;

//Definire interfaţă
public interface IServiciuOperatiuni {
    Double getCredit(OperatiuneContabila o);
    Double getDebit(OperatiuneContabila o);
    Double getSold(OperatiuneContabila o);
}
