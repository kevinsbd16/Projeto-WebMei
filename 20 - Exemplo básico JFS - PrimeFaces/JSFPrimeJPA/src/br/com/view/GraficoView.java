package br.com.view;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import br.com.controller.VendaController;
import br.com.model.Venda;
 
@ManagedBean(name = "graficoView")
public class GraficoView implements Serializable {
	
	public Calendar cal = Calendar.getInstance();
    private int ano = cal.get(Calendar.YEAR);// usando pra teste
    private int mes = cal.get(Calendar.MONTH);// usando para teste (meses vao de 0 a 11 devido ao java)
    private int dia = cal.get(Calendar.DATE);// usando pra teste
    private String data = dia+"/"+mes+"/"+ano;// usando pra teste
    private Date d = new Date(); // funcionando
    private String data2 = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d); //formatando pra jogar na tela
    private PieChartModel pieModel2;
    private double soma; // recebe o valor somado de venda do ano atual
    private List<Venda> relatorioAtual; // lista que traz todos os valores de vendas do ano
    
    public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}
    
    public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
    public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
 
    public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
    
    public double getSoma() {
		return soma;
	}

	public void setSoma(double soma) {
		this.soma = soma;
	}
	
	public void setRelatorioAtual(List<Venda> relatorioAtual) {
		this.relatorioAtual = relatorioAtual;
	}
    
    @PostConstruct
    public void init() {
        createPieModels();
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel2();
    }
      
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
        
        this.setRelatorioAtual(new VendaController().RelatorioAtual());
        this.soma = 0;
        for(Venda v2 : relatorioAtual ) {
        	soma += v2.getValor();
        }
        
        double Total= 8100000;
        soma = soma*100;
        double TotalF= Total - soma;
         
        pieModel2.set("Limite permitido", TotalF);
        pieModel2.set("Vendas atual", soma);
         
        pieModel2.setTitle("Vendas atual de: "+ ano +"" );
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(215);
        pieModel2.setShadow(false);
    }
     
}