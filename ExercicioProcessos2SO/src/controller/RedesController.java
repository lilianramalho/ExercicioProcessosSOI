package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String indentificaSO() {
		String sistemaOperacional = System.getProperty("os.name");
		System.out.println(sistemaOperacional);
		return sistemaOperacional;
	}
	
	public void listarProcessos(String sistemaOperacional) {
		Process process;
		try {
			if (sistemaOperacional.contains("Linux")) {
				process = Runtime.getRuntime().exec("lsof");
			}else {
			process = Runtime.getRuntime().exec("tasklist");
			}
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();	
			}		
			fluxo.close();
			buffer.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void matarProcessoPID(int pid, String sistemaOperacional) {
		Process process;
		try {
			if (sistemaOperacional.contains("Linux")) {
				process = Runtime.getRuntime().exec("kill -15 "+pid);
			}else {
				process = Runtime.getRuntime().exec("taskkill /pid "+pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void matarProcessoNome(String nome, String sistemaOperacional) {
		Process process;
		try {
			if (sistemaOperacional.contains("Linux")) {
				process = Runtime.getRuntime().exec("killall "+nome);
			}else {
				process = Runtime.getRuntime().exec("taskkill /im "+nome);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
