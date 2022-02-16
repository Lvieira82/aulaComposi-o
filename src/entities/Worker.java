package entities;

import java.util.ArrayList;
import entities.enums.WorkerLevel;
import java.util.Calendar;
import java.util.List;


public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //cria��o da lista de contrato
	
	public Worker() {
		
	}

	public Worker(String name, Double baseSalary, Department department) {
	
		this.name = name;
	
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}


	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract  contract) {
		contracts.remove(contract);
	}
	public double income(int year, int month) { //m�todo que faz a compara��o pra saber se m�s e ano batem.
		double sum = baseSalary; //soma sal�rio base
		Calendar cal = Calendar.getInstance(); //utiliza a classe calend�rio
		for(HourContract c : contracts) { //cria um laco pra conferirr cada contrato na lista de contratos
			cal.setTime(c.getDate()); // pega a variavel criada e pega sua data
			int c_year = cal.get(Calendar.YEAR);// para checar o ano extrai s� ele e compara com o param�tro digitado.
			int c_month = 1 + cal.get(Calendar.MONTH);// o mesmo para o m�s
			if (year == c_year && month == c_month) {// feita a copmpara��o se bater igual.
				sum += c.totalValue();// a soma � executada
			}
		}
		return sum;
	}
}
