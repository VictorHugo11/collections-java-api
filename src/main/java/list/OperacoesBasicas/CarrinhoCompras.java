package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    //atributos
    private List<Item> itemList;

    public CarrinhoCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        }
        else {
            System.out.println("A lista está vazia");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuant();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        }
        else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        }
        else {
            System.out.println("A ista está vazia");
        }
    }

    @Override
    public String toString () {
        return "CarrinhosCompras{" +
                "itens=" + itemList + "}";
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        // Adicionando itens ao carrinho
        carrinhoCompras.adicionarItem("caderno", 2d, 1);
        carrinhoCompras.adicionarItem("caneta", 1d, 5);
        carrinhoCompras.adicionarItem("lapis", 1d, 3);
        carrinhoCompras.adicionarItem("mochila", 40d, 1);

        // Exibindo os itens no carrinho
        carrinhoCompras.exibirItens();
        // Removendo um item do carrinho
        carrinhoCompras.removerItem("caneta");
        // Exibindo os itens atualizados no carrinho
        carrinhoCompras.exibirItens();
        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoCompras.calcularValorTotal());

    }
}
