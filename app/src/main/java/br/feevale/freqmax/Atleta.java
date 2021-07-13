package br.feevale.freqmax;

public class Atleta implements Comparable<Atleta> {
    String nome = "";
    Integer idade = 0;
    Integer freq = 0;

    public Atleta() { }

    public String getNome() {
        return nome;
    }

    public Integer getFreq() {
        return freq;
    }

    // Metódo de validação dos dados e cálculo da frequência
    public boolean valid(String nome, String idade) {
        this.nome = nome;

        // Tenta converter a idade digitada em int
        try {
            this.idade = Integer.parseInt(idade);
        } catch (NumberFormatException e) {
            return false;
        };

        // Se o nome ou a idade estão vazios
        if (nome == "" || idade == "") {
            return false;
        };

        // Se a idade é menor que zero ou maior que 220
        if (this.idade < 0 || this.idade > 220) {
            return false;
        };

        // Calcula a frequência
        this.freq = 220 - this.idade;
        return true;
    }

    public int compareTo(Atleta a) {
        if(this.freq < a.freq){
            return -1;
        }
        else if(this.freq > a.freq){
            return 1;
        }
        return 0;
    }
}