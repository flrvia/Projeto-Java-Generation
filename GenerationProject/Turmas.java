package GenerationProject;


import java.util.Scanner;

public class Turmas extends Metodos {
	private String programa;
	private String local;
	private int turma;
	private String forma;
 
	//Parâmetros referentes a qual programa será o cadastro

	Turmas (String programa, String estado, int numTurma, String metodo){


		this.programa=programa;
		this.local=estado;
		this.turma=numTurma;
		this.forma=metodo;
	}


	public String getPrograma() {
		return programa;
	}


	public void setPrograma(String programa) {
		this.programa = programa;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public int getTurma() {
		return turma;
	}


	public void setTurma(int turma) {
		this.turma = turma;
	}


	public String getForma() {
		return forma;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}
	
	//Metodo impressão para especifição do cadastro no console

	@Override
	public void imprimirInicio() {
		System.out.println("\n\t\t\t\t\t Bem-vinde a plataforma Bem-Estar da Generation Brasil!");
		System.out.println("\n\nCadastro para o programa "+programa+", para residentes do Estado de "+local+", da turma exclusiva para mulheres n�mero: "+turma+", com formato "+forma+".");
	}
 
	//Metodo de leitura e levantamento de dados
	@Override
	public void Leia(String nome, int genero, int idade, int comunidade, int cor, int renda, int filhos, int transicao) {
		
		//Contadores
		int contM=0, contMae=0, contMt=0, contI=0, somaI=0, contC=0,contB=0,contN=0,contA=0,contP=0,contInd=0, contRen=0;
		float mediaI;

		for(int x=0;x<3;x++) {
			//Lendo nome
			Scanner ler = new Scanner(System.in);
			System.out.println("\nDigite o nome do candidate: ");
			nome = ler.nextLine();

			//Lendo e avaliando condições de entrada para gênero
			System.out.println("\nInsira o gênero do candidate: ");
			System.out.println("\n(1) Feminino\n(2) Masculino\n(3) Não declarado");
			genero = ler.nextInt();	
			while(genero<1 || genero>3) {
				System.err.println("\nOpção inválida.");
				System.out.println("\nEntre com o gênero novamente:\n(1) Feminino\n(2) Masculino\n(3) Não declarado ");
				genero = ler.nextInt();			
			}

			//Lendo e avaliando condições de entrada para idade
			System.out.println("\nInsira a idade do candidate: ");
			idade = ler.nextInt();
			while(idade<1 || idade>120) {
				System.err.println("\nOpção inválida.");
				System.out.println("\nEntre com a idade novamente: ");
				idade = ler.nextInt();
			}

			//Lendo e avaliando condições de entrada para comunidade
			System.out.println("\nO candidate faz parte da comunidade LGBTQIAPN+? ");
			System.out.println("\n(1) Sim\n(2) Não\n(3) Prefere não informar");
			comunidade = ler.nextInt();
			while(comunidade<1 || comunidade>3) {
				System.err.println("\nOpção inválida.");
				System.out.println("\nDigite se o candidate faz parte da comunidade LGBTQIAPN+ novamente:\n(1) Sim\n(2) Não\n(3) Prefere não informar");
				comunidade = ler.nextInt();	
			}

			//Lendo e avaliando condições de entrada para declaração étnico-racial
			System.out.println("\nComo o candidate se autodeclara?");
			System.out.println("\n(1) Branco\n(2) Negro\n(3) Amarelo\n(4) Pardo\n(5) Indígena");
			cor=ler.nextInt();
			while(cor<1 || cor>5){
				System.err.println("\nOpção inválida.");
				System.out.println("\nEntre com a declaração étnico-racial novamente: \n(1) Branco\n(2) Negro\n(3) Amarelo\n(4) Pardo\n(5) Indígena");
				cor = ler.nextInt();
			}

			//Lendo e avaliando condições de entrada para filhos
			System.out.println("\nO candidate tem filhos? ");
			System.out.println("\n(1) Tem filhos\n(2) Não tem filhos");
			filhos = ler.nextInt();
			while(filhos<1 || filhos>2) {
				System.err.println("\nOpção inválida.");
				System.out.println("\nDigite se o candidate tem filhos novamente:\n(1) Tem filhos\n(2) Não tem filhos");
				filhos = ler.nextInt();	
			}	
			
			//Lendo e avaliando condições de entrada para transição de carreira
			System.out.println("\nO candidate está em transição de carreira? ");
			System.out.println("\n(1) Sim\n(2) Não");
			transicao = ler.nextInt();
			while(transicao<1 || transicao>2) {
				System.err.println("\nOpção inválida.");
				System.out.println("\nDigite se o candidate está em transição de carreira novamente:\n(1) Sim\n(2) Não");
				transicao = ler.nextInt();	
			}	
			
			//Declaração de renda
			System.out.println("\nO candidate tem renda per capita menor que um salário mínimo?");
			System.out.println("\n(1) Sim\n(2) Não\n");
			renda=ler.nextInt();
			while(renda<1 || renda>2){
				System.err.println("\nOpção inválida.");
				System.out.println("\nEntre com a declaração de salário novamente: \n(1) Sim\n(2) Não\n");
				renda = ler.nextInt();
			}
			
			
			//Desconsiderando entrada diferente de feminino no laço
			if(genero==2||genero==3) {
				System.err.println("Este candidate não pode fazer parte desta turma.");
				x--;
				
			}else {
				System.out.println("Cadastro realizado com sucesso!");
			}
			
			//Contador de mulheres
			 if (genero == 1) {
				contM++;
			}

			
			//Contadores étnico-raciais
			if(genero ==1 && cor == 1) {
				contB++;
			}else if(genero == 1 && cor==2) {
				contN++;
			}else if(genero == 1 && cor==3) {
				contA++;
			}else if(genero == 1 && cor==4) {
				contP++;
			}else if(genero == 1 && cor==5){
				contInd++;
			}
			
			//Contador de mães
			if (filhos == 1 && genero == 1) {
				contMae++;
			}
			
			//Contador de transição de carreira
			if (transicao == 1 && genero == 1) {
				contMt++;
			}
			
			//Média de idade: soma e contador
			if (idade>1 && idade<120 && genero == 1) {
				somaI += idade;
				contI++;
			}

			//Contador comunidade
			if (comunidade == 1 && genero == 1) {
				contC++;
			}
           
			//Contador de vulnerabilidade econômica
			if (renda == 1 && genero == 1) {
				contRen++;
			}
			
		}
		
		
		//Media de idade
		mediaI = somaI / contI;
		
		//Impressão dos dados
		System.out.println("Número de mulheres: "+contM);
		System.out.println("Média de idade da turma: "+mediaI);
		System.out.println("Número de mulheres LGBTQIAPN+: "+contC);
		System.out.println("Número de mulheres brancas: "+contB);
		System.out.println("Número de mulheres negras: "+contN);
		System.out.println("Número de mulheres amarelas: "+contA);
		System.out.println("Número de mulheres pardas: "+contP);
		System.out.println("Número de mulheres indígenas: "+contInd);
		System.out.println("Número de mães: "+contMae);
		System.out.println("Número de mulheres em transição de carreira: "+contMt);
		System.out.println("Número de mulheres em vulnerabilidade econômica: "+contRen);
		
	
	}
}



