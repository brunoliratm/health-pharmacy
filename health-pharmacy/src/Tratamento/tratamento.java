package Tratamento;

import java.io.IOException;

public class tratamento {

    public static void valorInvalido() throws InterruptedException{
        System.out.println("Valor Inválido, tente novamente");
        Thread.sleep(2000);
    }
    public static void opcaoInvalida() throws InterruptedException{
        System.out.println("Digite uma opção válida");
        Thread.sleep(2000);
    }


}