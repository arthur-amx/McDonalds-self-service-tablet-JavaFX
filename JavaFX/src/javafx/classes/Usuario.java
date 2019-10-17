package javafx.classes;

public class Usuario {

    private String Nome, Senha, Saldo;

    public Usuario(String nome, String senha) {
        this.Nome = nome;
        this.Senha = senha;
    }

    public Usuario(String nome) {
        this.Nome = nome;
        this.Senha = null;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

}
