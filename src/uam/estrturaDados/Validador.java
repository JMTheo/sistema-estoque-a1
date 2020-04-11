package uam.estrturaDados;

import java.util.Scanner;

public class Validador {
    private static Scanner scanner = new Scanner(System.in);

    public static int validarInt(String valor){
        int vlr;
        while(true){
            try{
                vlr = Integer.parseInt(valor);
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido !");
                return validarInt(scanner.nextLine());
            }
        }
        return vlr;
    }
}
