class Endereco {
    private String nomeRua;
    private int numero;

    public Endereco(String nomeRua, int numero) {
        this.nomeRua = nomeRua;
        this.numero = numero;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return nomeRua + ", " + numero;
    }
}

class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos)";
    }
}

class Departamento {
    private String nome;

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Escola {
    private String nome;
    private String CNPJ;
    private Endereco endereco;
    private Departamento[] departamentos;
    private Aluno[] discentes;
    private int nrDiscentes;
    private int nrDepartamentos;

    public Escola(String nome, String CNPJ) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.departamentos = new Departamento[10];
        this.discentes = new Aluno[1000];
        this.nrDiscentes = 0;
        this.nrDepartamentos = 0;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void criarDepartamento(String nomeDepartamento) {
        if (nrDepartamentos < departamentos.length) {
            departamentos[nrDepartamentos] = new Departamento(nomeDepartamento);
            nrDepartamentos++;
        } else {
            System.out.println("Nao e possivel criar outro Departamento.");
        }
    }

    public void matricularAluno(Aluno novoAluno) {
        if (nrDiscentes < discentes.length) {
            discentes[nrDiscentes] = novoAluno;
            nrDiscentes++;
        } else {
            System.out.println("Nao e possivel matricular mais alunos.");
        }
    }

    public void listarDepartamentos() {
        System.out.println("Departamentos da escola " + nome + ":");
        for (int i = 0; i < nrDepartamentos; i++) {
            System.out.println("- " + departamentos[i].getNome());
        }
    }

    public void listarAlunos() {
        System.out.println("Alunos matriculados:");
        for (int i = 0; i < nrDiscentes; i++) {
            System.out.println("- " + discentes[i]);
        }
    }
}

class Escola {
    public static void main(String[] args) {
        Escola escola = new Escola("Escola do Saber", "12.345.678/0001-99");

        escola.setEndereco(new Endereco("Rua X", 7));
        escola.criarDepartamento("Informatica");
        escola.criarDepartamento("Matematica");
        escola.matricularAluno(new Aluno("Maria", 16));
        escola.matricularAluno(new Aluno("Joao", 17));

        System.out.println("Endereco: " + escola.getEndereco());
        escola.listarDepartamentos();
        escola.listarAlunos();
    }
}
