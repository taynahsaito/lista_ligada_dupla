public class ListaDupla {
    //primeiro e ultimo são controles da lista:
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    //CONSTRUTOR PADRÃO
    public boolean estaVazia(){
        return primeiro == null; //como o primneiro elemento está nulo, não há nenhum elemento na lista.

    }
    public void insereInicio(int info){
        NoDuplo novo = new NoDuplo(info); //o novo tem o endereço de memoria 
        if(estaVazia()){
            ultimo = novo;
        }
        else{
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }
    
    public void insereFim(int info) {
        NoDuplo novo = new NoDuplo(info);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    public int removeInicio(){
        int info = primeiro.getInfo();
        primeiro = primeiro.getProximo();//vai na caixinha do primeiro e pega o valor do proximoo
        if (primeiro == ultimo){ //tinha um unico elemento
            ultimo = null; //esvaziou a lista
        }
        else{
            primeiro.setAnterior(null);
        }
        return info;
    }
}
