package GUI;

public class MenuProdutos {
  public static void menuProdutos() throws InterruptedException{
    System.out.println("Menu de Produtos\n\n");
    Thread.sleep(1500);
    System.out.println("Digite o número da opção desejada:\n");
    System.out.println("[1] Adicionar produto");
    System.out.println("[2] Remover produto");
    System.out.println("[3] Atualizar produto");
    System.out.println("[4] Visualizar produtos");
    System.out.println("[5] Retornar ao menu anterior");
    System.out.println("[6] Sair do aplicativo");
  }
}
