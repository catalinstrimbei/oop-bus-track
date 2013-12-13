package org.comenzi.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

public class FormMenu {
	private String formCurent;
	
	/* menu versiunea 1*/
	public void actionChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		System.out.println("V1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	
	public String changeFormCurent(){
		System.out.println("V2: Change form request: " + this.formCurent);
		return this.formCurent;
	}
	
	
	/* menu versiunea 2*/
	public void actionSrcChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		System.out.println("V2: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	public String changeSrcFormCurent(){
		System.out.println("V2: Change form request: " + this.formCurent);
		return "menuv2/FormMenuV2";
	}
	public String getSrcCurentForm(){
		String urlForm = "/AppBanner.xhtml"; 
		if (this.formCurent != null)
			urlForm = "/" + this.formCurent + ".xhtml";
		System.out.println("V2/3: FINAL Curent Form Url: " + urlForm);
		return urlForm;
		
	}
	
	/* menu versiunea 3*/
	private Map<String, String> formulare = new HashMap<String, String>();
	public FormMenu(){
		formulare.put("Editare clienti", "FormClienti");
		formulare.put("Editare comenzi", "FormComenzi");
		formulare.put("Editare produse", "FormProduse");
		formulare.put("Lista clienti", "RaportClienti");		
	}
	public List<String> getFormulare() {
		System.out.println("V3: Get Formulare");
		List<String> formList = new ArrayList<String>();
		formList.addAll(this.formulare.keySet());
		return formList;
	}
	public void actionSrcGetForm(ActionEvent evt){
		UICommand uiComanda = (UICommand) evt.getComponent();
		System.out.println("V3: Generic Action Change form request: " + uiComanda.getValue());
		this.formCurent = this.formulare.get(uiComanda.getValue());
		System.out.println("V3: Generic Action Change form result: " + this.formCurent);			
	}	
	public String changeSrcGetForm(){
		System.out.println("V3: Change form request: " + this.formCurent);
		return "menuv3/FormMenuV3";
	}
	//public String getSrcCurentForm()
	private UIOutput footerTxt;
	public UIOutput getFooterTxt() {
		System.out.println("Getting footerTxt ... ");
		footerTxt = new UIOutput();
		footerTxt.setId("footerTxt");
		//footerTxt.setValue("Footer Form Menu");
		footerTxt.getAttributes().put("value", "Form Main Menu");
		footerTxt.getAttributes().put("style", "color: red");
		System.out.println("====================================");
		for(String attk: footerTxt.getAttributes().keySet()){
			System.out.println("footerTxt." + attk + " = " + footerTxt.getAttributes().get(attk));
		}		
		
		return footerTxt;
	}

	public void setFooterTxt(UIOutput footerTxt) {
		this.footerTxt = footerTxt;
		System.out.println("Setting footerTxt");
		System.out.println("====================================");
		for(String attk: footerTxt.getAttributes().keySet()){
			System.out.println("footerTxt." + attk + " = " + footerTxt.getAttributes().get(attk));
		}		
		/*
		footerTxt.getAttributes().put("style", "color: red");
		footerTxt.setValue("Footer Form Menu");
		System.out.println("====================================");
		for(String attk: footerTxt.getAttributes().keySet()){
			System.out.println("footerTxt." + attk + " = " + footerTxt.getAttributes().get(attk));
		}		
		//footerTxt.getChildren().add(arg0)
		*/
		
	}

	
	

}