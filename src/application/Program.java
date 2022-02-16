package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;



public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("entre com o nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("entre com o nivel: ");
		String workerLevel = sc.nextLine();
		System.out.print("entre com o Salário base: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, baseSalary, new Department(departmentName), WorkerLevel.valueOf(workerLevel));
		
		System.out.print("how many contracts to this worker?: ");
		int contractsNumber = sc.nextInt();
		
		for (int i=1; i <= contractsNumber; i++) {
			System.out.print("data: dd/MM/yyyy: ");
			Date date = sdf.parse(sc.next());
			System.out.print("digite o valor por hora:");
			double valuePerHour = sc.nextDouble();
			System.out.print("quantidade de horas: ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract); 
		}
		System.out.println();
		System.out.print("Agora entre com o (MM/YYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("name: " + worker.getName());
		System.out.println("Deparrment:" + worker.getDepartment().getName());
		System.out.println("Income for" + monthAndYear + " :" + String.format("%.2f" , worker.income(year, month)));
		
		sc.close();
		

	}

}
