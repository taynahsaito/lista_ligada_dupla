public class ListaDupla {
    //primeiro e ultimo são controles da lista:
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    //CONSTRUTOR PADRÃO
    public boolean estaVazia(){
        return primeiro == null; //como o primeiro elemento está nulo, não há nenhum elemento na lista.
    }

    //construtor criado no aulão de monitoria para a p1:
    public void insereTerceiraCasa(int info){
        NoDuplo novo = new NoDuplo(info);//criamos um nó novo para inserir na lista com uma informação(valor)
        NoDuplo atual = primeiro;
        int cont = 1; //começamos o contador em 1, para ir percorrendo a lista e seus valores, já que listas não tem indices
        //se a lista estiver vazia, vai ser igual a null
        // o loop while percorre percorre enquanto o nó atual for diferente de null e 3, logo ele parará na casa 3 se for diferente de null
        while (atual != null && cont != 3) {
            atual = atual.getProximo(); //atual.getProximo() é igual a atual + 1, aqui estamos na segunda posição
            cont++; //informamos ao nosso contador
        }
        //onde você esta nesse momento? R: lista dupla = [0,1,*2*,3,4], estamos no 2, na terceira casa/cont 3
        //valor do no novo = 8, então... 
        novo.setProximo(atual);//mudamos a referencia do proximo nó do nó novo 8 para o nó atual, no caso, 2...
        novo.setAnterior(atual.getAnterior()); //mudamos a referenciação do nó anterior do nó novo para o anterior do nó atual, ou seja, 1
        //dessa forma, fizemos a inserção do novo nó 8 na casa 3, ficando no meio do nó com valor 1 e do nó com valor 2
        novo.getProximo().setAnterior(novo);//pegamos o proximo do novo nó, e referenciamos seu nó anterior para o nó novo 8, já que é uma lista dupla. fazendo, então, a ligação para seu anterior.
        novo.getAnterior().setProximo(novo); //pegamos o anterior do novo nó, e referenciamos seu próximo para o novo nó 8, 
    }

    public void insereInicio(int info){
        NoDuplo novo = new NoDuplo(info); //o novo tem o endereço de memoria 
        if(estaVazia()){
            ultimo = novo; //se estiver vazia, o ultimo nó será o novo, ja que não há elementos na lista
        }
        else{
            //se não estiver vazia...
            novo.setProximo(primeiro);//setamos o próx nó do nó novo para ser o primeiro elemento da lista. por exemplo: [1,2,5], referenciamos o prox no do no novo que vamos inserir para 1
            primeiro.setAnterior(novo);//pegamos o primeiro nó atual e mudamos sua referenciação do no anterior para o novo nó, porque é uma lista dupla.
        }
        primeiro = novo;//logo, o primeiro será o novo nó, porque é inserido no inicio.
    }
    
    public void insereFim(int info) {
        NoDuplo novo = new NoDuplo(info); 
        if (estaVazia()) {
            primeiro = novo; 
        } else {
            novo.setAnterior(ultimo); //pegamos a referenciação do nó anterior ao novo, e definimos como o ultimo atual da lista.
            ultimo.setProximo(novo); //definimos o proximo nó referenciado pelo ultimo elemento atual para o novo nó, transformando assim, o novo nó em ultimo. 
        }
        ultimo = novo;
    }

    public int removeInicio(){
        int info = primeiro.getInfo(); //pega a info(valor) do primeiro elemento da lista
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
        ultimo = ultimo.getAnterior(); //define o elemento antes do ultimo como ultimo.
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
            NoDuplo aux = primeiro;//a variavel auxiliar recebe o elemento da primeira posição da lista
            int cont = 1; 
            while (aux != ultimo && cont < pos) { //rodamos o while enquanto não chega no fim da lista && o contador for menor que a posição
                aux = aux.getProximo(); //andamos de posição, estamos no próximo elemento
                cont++; //incrementa o contador
                //o laço roda até o ultimo elemento da lista e até o contador chegar a posição escolhida.
            }
            if(aux == ultimo){
                insereFim(info);
            }
            else{
                NoDuplo novo = new NoDuplo(info);
                novo.setProximo(aux); //mudamos a referencia do proximo no do no novo para o nó auxiliar criado(atual)
                novo.setAnterior(aux.getAnterior());//mudamos a referencia para o no anterior do nó novo para o nó anterior do nó auxiliar(atual - se encaixa no meio).
                novo.getProximo().setAnterior(novo);//pegamos o proximo no referenciado pelo no novo e definimos seu no anterior como o propio no novo.
                novo.getAnterior().setProximo(novo);//pegamos o anterior do no novo, e determina o proximo no como o proprio no novo.
            }
        }
    }
}


//tudo que acontece dinamicamente é em forma de execução
//dumb knot - inicializar a lista com um nó vazio, que é apontado pelo primeiro e pelo último, e isso que caracteriza a lista como vazia
//podem existir diferentes implementações para a mesma especificação
//tokens são palavras computacionais
// as linked lists do java são feitas a partir da estrutura deque - que também é usada na própria parte livre da memória