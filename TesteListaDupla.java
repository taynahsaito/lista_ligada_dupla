import java.util.Random;

public class TesteListaDupla {
    public static void main(String[] args) {
        Random random = new Random();
        ListaDupla lDupla = new ListaDupla();
        do {
            if(random.nextBoolean()){ //verdadeiro: insere
                if (random.nextBoolean()) { //verdadeiro: inserção no inicio
                    lDupla.insereInicio(random.nextInt(10));
                    System.out.println("insere inicio");
                }
                else{//se for falso, inserção no fim
                    lDupla.insereFim(random.nextInt(10)); //valor de 0 a 9
                    System.out.println("insere fim");
                }
            }
            else if (!lDupla.estaVazia()){//falso: remove, se não estiver vazia
                if(random.nextBoolean()){// se for verdadeiro, remove do fim
                    System.out.println(lDupla.removeFim() + " saiu do final");
                }
                else{// se for falso, remove do inicio 
                    System.out.println(lDupla.removeInicio() + " saiu do inicio");
                }
            }
            System.out.println(lDupla);
        }while (!lDupla.estaVazia());
    }
}
