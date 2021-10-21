package Modelo
//created on 16-10-2021 at 8:12:54
//class 'TablaCocina'
public class TablaCocina{
// variables for TablaCocina

	private int idtabla_cocina;
	private String codigo_cocina;

public TablaCocina(){
}

public TablaCocina(int idtabla_cocina,String codigo_cocina){
	this.idtabla_cocina = idtabla_cocina;
	this.codigo_cocina = codigo_cocina;
}

// setters and getters for TablaCocina

// setter method for 'idtabla_cocina'
public void setidtabla_cocina(int idtabla_cocina){
    this.idtabla_cocina = idtabla_cocina;
}

// getter method for 'idtabla_cocina'
public int getidtabla_cocina(int idtabla_cocina){
    return this.idtabla_cocina = idtabla_cocina;
}
// setter method for 'codigo_cocina'
public void setcodigo_cocina(String codigo_cocina){
    this.codigo_cocina = codigo_cocina;
}

// getter method for 'codigo_cocina'
public String getcodigo_cocina(String codigo_cocina){
    return this.codigo_cocina = codigo_cocina;
}

}
