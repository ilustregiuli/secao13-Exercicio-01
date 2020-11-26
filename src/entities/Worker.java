package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// variaveis methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	//methods
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract){
		this.contracts.remove(contract);
	}
	
	public double income(Integer year, Integer month) {
		double sum = baseSalary;		
		
		Calendar cal = Calendar.getInstance();		// criando um calendário (uma instância para usar)
		
		for(HourContract c : contracts) {
			
			cal.setTime(c.getDate());				// usando o método de alterar o calendário, coloca-se a data de cada contrato "c" 
													// dentro do calendário "cal"
			
			
			int c_year = cal.get(Calendar.YEAR);	// com a variável "cal" setado para o "date" do contrato, pegamos a constante "Year"
			int c_month = cal.get(Calendar.MONTH) +1 ; // aqui pegamos a constante "month" e somamos 1 pois o mês inicia do zero	
			
			
			
			if(year  == c_year && month == c_month) { // "se o valor informado no argumento (year e month) for igual aos valores do contrato
				sum += c.totalValue();				// analisado, então acrescenta a soma o valor total desse contrato.	
			}
		}
		return sum;
		
		}

}
