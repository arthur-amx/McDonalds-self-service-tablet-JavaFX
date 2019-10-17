/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.classes.Admin;
import javafx.classes.Pedido;
import javafx.classes.Produto;
import javafx.classes.Usuario;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    static public ArrayList<Produto> produtos = new ArrayList();
    static public ArrayList<Usuario> usuarios = new ArrayList();
    static public Admin a = main.a;
    static public Usuario atual;

    static boolean cadastrarPedido(Pedido pedido) throws IOException {
        try {
            File fcadastro = new File(pedido.getCliente().getNome() + ".txt");
            fcadastro.createNewFile();
            FileWriter fw = new FileWriter(pedido.getCliente().getNome() + ".txt", true);
            BufferedWriter fwriter = new BufferedWriter(fw);
            for (int i = 0; i < pedido.produtos.size(); i++) {
                fwriter.write(pedido.produtos.get(i).getNome() + " -> " + pedido.produtos.get(i).getQtd() + "\r\n");
            }
            fwriter.write("Total: R$" + pedido.getValor() + "\r\n" + "Cliente: " + pedido.getCliente().getNome() + "\r\n\n");
            fwriter.close();
            return true;
        } catch (FileNotFoundException s) {
            return false;
        }
    }

    static boolean cadastrarUsuario(Usuario usuario) throws IOException {
        try {
            File fcadastro = new File("usuarios.txt");
            fcadastro.createNewFile();
            FileWriter fw = new FileWriter("usuarios.txt", true);
            BufferedWriter fwriter = new BufferedWriter(fw);
            fwriter.write(usuario.getNome() + "\r\n" + usuario.getSenha() + "\r\n" + usuario.getSaldo() + "\r\n");
            fwriter.close();
            return true;
        } catch (FileNotFoundException s) {
            return false;
        }
    }

    static boolean cadastrarSenha(String senha) throws IOException {
        try {
            File fcadastro = new File("senha.txt");
            fcadastro.createNewFile();
            FileWriter fw = new FileWriter("senha.txt", false);
            BufferedWriter fwriter = new BufferedWriter(fw);
            fwriter.write(senha + "\r\n");
            fwriter.close();
            return true;
        } catch (FileNotFoundException s) {
            return false;
        }
    }

    static boolean cadastrarProduto(Produto produto) throws IOException {
        try {
            File fcadastro = new File("produtos.txt");
            fcadastro.createNewFile();
            FileWriter fw = new FileWriter("produtos.txt", true);
            BufferedWriter fwriter = new BufferedWriter(fw);
            fwriter.write(produto.getNome() + "\r\n" + produto.getPreco() + "\r\n" + produto.getImg() + "\r\n" + produto.getTipo() + "\r\n");
            fwriter.close();
            return true;
        } catch (FileNotFoundException s) {
            return false;
        }
    }

    static boolean verificarUsuario(String nome, String senha) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (nome.equals(usuarios.get(i).getNome()) && senha.equals(usuarios.get(i).getSenha())) {
                return true;
            }
        }
        return false;
    }

    static boolean verificarSenha(String senha) {
        if (((a.getSenha().equals(senha))) != true) {
            return false;
        } else {
            return true;
        }
    }

    static boolean verificarProduto(String nome, String tipo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (nome.equals(produtos.get(i).getNome()) && tipo.equals(produtos.get(i).getTipo())) {
                return true;
            }
        }
        return false;
    }

    static Usuario retorno(String nome, String senha) {
        if (verificarUsuario(nome, senha) == true) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (nome.equals(usuarios.get(i).getNome()) && senha.equals(usuarios.get(i).getSenha())) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }

    static List<Produto> retorno() {

        List<Produto> retorno = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            Produto prod = new Produto();
            prod.setNome(produtos.get(i).getNome());
            prod.setPreco(produtos.get(i).getPreco());
            prod.setTipo(produtos.get(i).getTipo());
            prod.setImg(produtos.get(i).getImg());
            prod.setQtd(produtos.get(i).getQtd());
            retorno.add(prod);
        }

        return retorno;

    }

    static Produto retornoProduto(String nome, String tipo) {
        if (verificarProduto(nome, tipo) == true) {
            for (int i = 0; i < produtos.size(); i++) {
                if (nome.equals(produtos.get(i).getNome()) && tipo.equals(produtos.get(i).getTipo())) {
                    return produtos.get(i);
                }
            }
        }
        return null;
    }

    static List<Produto> retornoPedido(Pedido p) {

        List<Produto> retorno = new ArrayList<>();

        for (int i = 0; i < p.produtos.size(); i++) {
            Produto prod = new Produto();
            prod.setNome(p.produtos.get(i).getNome());
            prod.setPreco(p.produtos.get(i).getPreco());
            prod.setTipo(p.produtos.get(i).getTipo());
            prod.setImg(p.produtos.get(i).getImg());
            prod.setQtd(p.produtos.get(i).getQtd());
            retorno.add(prod);
        }

        return retorno;

    }

    static void lerUsuario() throws IOException {
        File forigem = new File("usuarios.txt");
        if (forigem.isFile() && forigem.exists()) {
            FileReader f = new FileReader("usuarios.txt");
            BufferedReader readerf = new BufferedReader(f);
            String senha, nome, saldo;
            nome = readerf.readLine();
            while (nome != null) {
                senha = readerf.readLine();
                saldo = readerf.readLine();
                Usuario usuario = new Usuario(nome, senha);
                usuario.setSaldo(saldo);
                usuarios.add(usuario);
                nome = readerf.readLine();
            }
            readerf.close();
        }
    }

    static void lerSenha() throws IOException {
        File forigem = new File("senha.txt");
        if (forigem.isFile() && forigem.exists()) {
            FileReader f = new FileReader("senha.txt");
            BufferedReader readerf = new BufferedReader(f);
            String senha;
            senha = readerf.readLine();

            a.setSenha(senha);

            readerf.close();
        }
    }

    static void lerProduto() throws IOException {
        File forigem = new File("produtos.txt");
        if (forigem.isFile() && forigem.exists()) {
            FileReader f = new FileReader("produtos.txt");
            BufferedReader readerf = new BufferedReader(f);
            String nome, preco, img, tipo;
            nome = readerf.readLine();
            while (nome != null) {
                preco = readerf.readLine();
                img = readerf.readLine();
                tipo = readerf.readLine();
                Produto prod = new Produto();
                prod.setImg(img);
                prod.setNome(nome);
                prod.setPreco(preco);
                prod.setTipo(tipo);
                produtos.add(prod);
                nome = readerf.readLine();
            }
            readerf.close();
        }
    }

    public static Usuario getAtual() {
        return atual;
    }

    public static void setAtual(Usuario aAtual) {
        atual = aAtual;
    }

    public static void apagarTxt() {
        File f1 = new File("produtos.txt");
        File f2 = new File("usuarios.txt");
        File f3 = new File("senha.txt");
        f1.delete();
        f2.delete();
        f3.delete();
    }

    static int sizeProduto() {
        return produtos.size();
    }

}
