package GUI;

public class MenuAdm {
    public static void menuADM() throws InterruptedException{
        System.out.println("Menu de Administração\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Remover Funcionário");
        System.out.println("[2] Remover Cliente");
        System.out.println("[3] Lucro total");
        System.out.println("[4] Histórico de vendas");
        System.out.println("[5] Ver clientes cadastrados");
        System.out.println("[6] Ver funcionários cadastrados");
        System.out.println("[7] Retornar ao menu de login");
    }
}
