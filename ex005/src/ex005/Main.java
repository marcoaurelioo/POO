package ex005;

public class Main {

	public static void main(String[] args) {
		
		Turma turma = new Turma("Engenharia");

        
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Fulano");
        aluno1.setAnoNascimento(2000);
        aluno1.setMediaGlobal(7.5);
        turma.adicionarAlunos(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Ciclano");
        aluno2.setAnoNascimento(1999);
        aluno2.setMediaGlobal(8.0);
        turma.adicionarAlunos(aluno2);

        Aluno aluno3 = new Aluno();
        aluno3.setNome("Beltrano");
        aluno3.setAnoNascimento(2001);
        aluno3.setMediaGlobal(6.8);
        turma.adicionarAlunos(aluno3);

        
        Aluno alunoComMaiorMedia = turma.alunoComMaiorMedia();
        System.out.println("Aluno com a maior média: " + alunoComMaiorMedia.getNome());

        
        Aluno alunoMaisNovo = turma.alunoMaisNovo();
        System.out.println("Aluno mais novo: " + alunoMaisNovo.getNome());
		
	}

}
