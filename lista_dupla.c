#include <stdio.h> //stdio - input e output e h - header(cabeçalho)
#include <stdlib.h>

//quando nomeia-se uma struct, precisa de uma tag (nesse caso, é o 'no')
typedef struct no {
    int info;
    struct no * anterior; //tipo da variavel 'anterior': ponteiro de struct nó
    struct no * proximo;

} t_no; //apelido do struct
 

typedef struct lista {
    t_no * primeiro;
    t_no * ultimo;
} t_lista; //apelido


t_no * constroi_no (int info) {
    t_no * no = (t_no *) malloc(sizeof(t_no)); //malloc devolve um endereço de um bloco de memoria alocada.
    //a variavel no também é um ponteiro
    if (no != NULL){
        no->info = info; //'->' é o 'this' do java / vou la na regiao/campo que o no aponta e acesso ela.
        no->anterior = NULL;
    }
    return no; 
}

void inicializa_lista (t_lista * lista) { //a lista é um ponteiro de t_lista
    lista->primeiro = NULL; 
    lista->ultimo = NULL;
}

//tudo que é 0 é falso, tudo que é diferente de 0 é verdadeiro!! por isso não existe boolean no c
int esta_vazia (t_lista * lista){
    return primeiro == NULL;
}

// //a função main é padrão no c
// int main(){
//     t_no * no1 = constroi_no(10); 
//     printf("valor de no1: %p\n", no1);
//     printf("conteudo apontado por no1 no campo info: %d\n", no1->info); //se colocar o & antes variavel, ele retorna o endereço (posição da variavel na memoria)
//     printf("onde esta a variavel no1: %p\n", &no1); //& = operador referencia.
//     printf("tamanho da variavel no1: %ld\n", sizeof(no1)); //ld = long unsigned int
//     printf("tamanho do bloco apontado por no1: %ld\n", sizeof((*no1)));//* na frente = operador de referencia - conteudo apontado por no1
//     return 0;
// }

int main(){
    t_lista lista;
    printf("primeiro: %p\n", lista.primeiro);
    printf("ultimo: %p\n", lista.ultimo);
    if (esta_vazia(&lista)){
        printf("lista vaziaan");
    }
    else{
        printf("nao esta vazia\n");
    }
    if (esta_vazia(&lista)){
        printf("lista vazia\n");
    }
    else{
        printf("nao esta vazia\n");
    }
    inicializa_lista(&lista);
    printf("primeiro depois: %p\n", lista.primeiro);
    printf("ultimo depois: %p\n", lista.ultimo);
    return 0;
}

//a memoria é armazenada direto pelo SO, não tem JVM que nem o java
//quando é ponteiro, operador '->' e quando é estrutura, operador '.'