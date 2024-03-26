public class TesteInserePosicao {
    public static void main(String[] args) {
        ListaDupla lDupla = new ListaDupla();
        lDupla.insereElementoPosicao(10, 2);
        System.out.println(lDupla);
        lDupla.insereElementoPosicao(20, 2);
        System.out.println(lDupla);
        lDupla.insereElementoPosicao(30, 1);
        System.out.println(lDupla);
        lDupla.insereElementoPosicao(40, 2);
        System.out.println(lDupla);
    }
}
