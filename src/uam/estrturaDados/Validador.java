package uam.estrturaDados;

import java.util.Scanner;

    public class Validador {
        private static Scanner scanner = new Scanner(System.in);

        public static int validarInt(String valor) {
            int vlr;
            try {
                vlr = Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido !");
                return validarInt(scanner.nextLine());
            }
            return vlr;
        }

        public static boolean checarLista(Lista lista) {
            if (lista == null) {
                System.out.println("É preciso iniciar a lista primeiro antes de acessar essa função !");
                return false;
            }
            return true;
        }
}
