package ex010;
import java.util.List;
import java.util.ArrayList;

public class Turma {
	private List<Aluno> alunos;
	private String curso;
	
	public Turma(String curso) {
		this.curso = curso;
		this.alunos = new ArrayList<>();
	}
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
    public Aluno alunoComMaiorMedia() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno alunoMaiorMedia = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.getMediaGlobal() > alunoMaiorMedia.getMediaGlobal()) {
                alunoMaiorMedia = aluno;
            }
        }
        return alunoMaiorMedia;
    }

    public Aluno alunoMaisNovo() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno alunoMaisNovo = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.getAnoNascimento() > alunoMaisNovo.getAnoNascimento()) {
                alunoMaisNovo = aluno;
            }
        }
        return alunoMaisNovo;
    }
}
