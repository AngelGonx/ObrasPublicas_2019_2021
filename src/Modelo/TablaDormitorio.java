package Modelo
//created on 16-10-2021 at 8:12:54
//class 'TablaDormitorio'
public class TablaDormitorio{
// variables for TablaDormitorio

	private int idtabla_dormitorio;
	private String codigo_dormitorio;

public TablaDormitorio(){
}

public TablaDormitorio(int idtabla_dormitorio,String codigo_dormitorio){
	this.idtabla_dormitorio = idtabla_dormitorio;
	this.codigo_dormitorio = codigo_dormitorio;
}

// setters and getters for TablaDormitorio

// setter method for 'idtabla_dormitorio'
public void setidtabla_dormitorio(int idtabla_dormitorio){
    this.idtabla_dormitorio = idtabla_dormitorio;
}

// getter method for 'idtabla_dormitorio'
public int getidtabla_dormitorio(int idtabla_dormitorio){
    return this.idtabla_dormitorio = idtabla_dormitorio;
}
// setter method for 'codigo_dormitorio'
public void setcodigo_dormitorio(String codigo_dormitorio){
    this.codigo_dormitorio = codigo_dormitorio;
}

// getter method for 'codigo_dormitorio'
public String getcodigo_dormitorio(String codigo_dormitorio){
    return this.codigo_dormitorio = codigo_dormitorio;
}

}
