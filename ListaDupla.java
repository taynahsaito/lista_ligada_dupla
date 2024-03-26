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
        primeiro = primeiro.getProximo();//vai na caixinha do primeiro e pega o valor do proximo - agora a variavel primeiro referencia o segundo elemento da lista
        if (primeiro == ultimo){ //tinha um unico elemento  como tem só int, para nao devolvermos -1, deixamos a responsabilidade de testar se a lista está vazia para a aplicação
            ultimo = null; //esvaziou a lista
        }
        else{
            primeiro.setAnterior(null); // apagamos o endereço do antigo primeiro da caixinha do segundo (o novo primeiro), cortando as amarras daquele primeiro elemento com a lista.
        }
        return info;
    }

    public int removeFim () {
        int info = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null){//esvaziou a lista
            primeiro = null;
        }
        else{
            ultimo.setProximo(null); //corta a referencia(ponteiro) para o ultimo elemento e, automaticamente, remove o ultimo elemento.
        }
        return info;
    }

    @Override // avisa o compilador e o dev que o metodo a seguir é uma sobrescrita
    public String toString (){ // forma de processar os dados que estão na lista
        String s = "";
        if (estaVazia()){
            s += "lista vazia";
        }
        else{
            NoDuplo aux = primeiro;
            s += "//< = ";
            while (aux != null) {
                s += aux + " = ";
                aux = aux.getProximo();
            }
            s += " >//";
        }
        return s;
    }

    public void insereElementoPosicao(int info,int pos){ //vantagem de chamar outros métodos dentro do método: menos código, mais legibilidade de codigo. desvantagens = nao podemos criar o no antes de chamar o metodo
        if (estaVazia() || pos == 1){
            insereInicio(info);
        }
        else{ // encontrar a posicao
            NoDuplo aux = primeiro;
            int cont = 1;
            while (aux != ultimo && cont < pos) {
                aux = aux.getProximo();
                cont++;
            }
            if(aux == ultimo){
                insereFim(info);
            }
            else{
                NoDuplo novo = new NoDuplo(info);
                novo.setProximo(aux);
                novo.setAnterior(aux.getAnterior());
                novo.getProximo().setAnterior(novo);
                novo.getAnterior().setProximo(novo);
            }
        }
    }
}


//tudo que acontece dinamicamente é em forma de execução
//dumb knot - inicializar a lista com um nó vazio, que é apontado pelo primeiro e pelo último, e isso que caracteriza a lista como vazia
//podem existir diferentes implementações para a mesma especificação
//tokens são palavras computacionais
// as linked lists do java são feitas a partir da estrutura deque - que também é usada na própria parte livre da memória