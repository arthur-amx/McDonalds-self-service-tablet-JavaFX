package javafx;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.List;
import static javafx.ManipularArquivo.produtos;
import static javafx.ManipularArquivo.usuarios;
import javafx.classes.Admin;
import javafx.classes.Pedido;
import javafx.classes.Produto;
import javafx.classes.Usuario;
import javafx.excecoes.NomeUsuarioInvalidoException;
import javafx.excecoes.PrecoProdutoInvalidoException;
import javafx.excecoes.SenhaInvalidaException;
import javax.swing.JOptionPane;

public class Cadastro {

    public boolean cadastra(String nome, String senha) throws FontFormatException, IOException, NomeUsuarioInvalidoException {
        if ((nome.equals("") != true) || (senha.equals("") != true)) {
            if ((ManipularArquivo.verificarUsuario(nome, senha)) == true) {
                JOptionPane.showMessageDialog(null, "Erro na realização do Cadastro!");
                return false;
            } else {
                Usuario usuario = new Usuario(nome, senha);
                usuario.setSaldo("0");
                ManipularArquivo.usuarios.add(usuario);
                ManipularArquivo.cadastrarUsuario(usuario);;
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                atualizar();
                return true;
            }
        } else {
            throw new NomeUsuarioInvalidoException("Erro, nome e/ou senha Inválido(s)!!!");
        }
    }

    public boolean cadastra(String senha) throws FontFormatException, IOException, SenhaInvalidaException {
        if (senha.equals("") != true) {
            if ((ManipularArquivo.verificarSenha(senha)) == true) {
                JOptionPane.showMessageDialog(null, "Erro na alteração da senha!");
                return false;
            } else {
                ManipularArquivo.a.setSenha(senha);
                ManipularArquivo.cadastrarSenha(senha);
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
                return true;
            }
        } else {
            throw new SenhaInvalidaException("Erro, senha Inválida!!!");
        }
    }

    public boolean cadastraProduto(Produto p) throws FontFormatException, IOException, NomeUsuarioInvalidoException, PrecoProdutoInvalidoException {
        if ((p.getPreco().equals("")) != true) {
            if ((p.getNome().equals("") != true) || (p.getTipo().equals("") != true)) {
                if (p.getPreco().equals("") != true) {
                    if ((ManipularArquivo.verificarProduto(p.getNome(), p.getTipo())) == true) {
                        JOptionPane.showMessageDialog(null, "Erro na realização do Cadastro!");
                        return false;
                    } else {
                        Produto prod = new Produto();
                        prod.setNome(p.getNome());
                        prod.setPreco(p.getPreco());
                        prod.setTipo(p.getTipo());
                        if (p.getImg().equals("") == true) {
                            prod.setImg("null");
                        } else {
                            prod.setImg(p.getImg());
                        }
                        ManipularArquivo.cadastrarProduto(prod);
                        ManipularArquivo.produtos.add(prod);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        atualizar();
                        return true;
                    }
                }
            } else {
                throw new NomeUsuarioInvalidoException("Erro, nome e/ou tipo Inválido(s)!!!");
            }
        } else {
            throw new PrecoProdutoInvalidoException("Erro, preço para produto Inválido!!!");
        }

        return false;
    }

    public void cadastraPedido(Pedido p) throws IOException {
        ManipularArquivo.cadastrarPedido(p);
    }

    public boolean removerProduto(Produto p) throws IOException {
        if (ManipularArquivo.verificarProduto(p.getNome(), p.getTipo()) == true) {
            ManipularArquivo.produtos.remove(p);
            atualizar();
            return true;
        } else {
            return false;
        }
    }

    public void removerProduto(String nome, String tipo) throws IOException {
        if (ManipularArquivo.verificarProduto(nome, tipo) == true) {
            Produto p = ManipularArquivo.retornoProduto(nome, tipo);
            ManipularArquivo.produtos.remove(p);
            atualizar();
        }
    }

    public boolean verifica(String senha) {
        if (ManipularArquivo.verificarSenha(senha) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifica(String UsuarioLogin, String SenhaLogin) {
        if (ManipularArquivo.verificarUsuario(UsuarioLogin, SenhaLogin) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaProduto(String nome, String tipo) {
        if (ManipularArquivo.verificarProduto(nome, tipo) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario retorno(String UsuarioLogin, String SenhaLogin) {
        if (ManipularArquivo.retorno(UsuarioLogin, SenhaLogin) != null) {
            return ManipularArquivo.retorno(UsuarioLogin, SenhaLogin);
        } else {
            return null;
        }
    }

    public List listar() {
        return ManipularArquivo.retorno();
    }

    public List listarPedido(Pedido p) {
        return ManipularArquivo.retornoPedido(p);
    }

    public void setar(Usuario u) {
        ManipularArquivo.setAtual(u);
    }

    public Usuario pegar() {
        return ManipularArquivo.atual;
    }

    public void atualizar() throws IOException {
        ManipularArquivo.apagarTxt();
        int cont = 0;
        System.out.println(ManipularArquivo.produtos.size());
        while (cont < ManipularArquivo.produtos.size()) {
            ManipularArquivo.cadastrarProduto(produtos.get(cont));
            cont++;
        }
        cont = 0;
        while (cont < ManipularArquivo.usuarios.size()) {
            ManipularArquivo.cadastrarUsuario(usuarios.get(cont));
            cont++;
        }
        cont = 0;
        ManipularArquivo.cadastrarSenha(ManipularArquivo.a.getSenha());
    }

}
