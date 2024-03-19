public class NoDuplo{
    private int info;
    private NoDuplo proximo;
    private NoDuplo anterior;
    public NoDuplo (int info){
        setInfo(info);
        setProximo(null);
        setAnterior(null);
    }
    public int getInfo(){
        return info;
    }
    public NoDuplo getProximo(){
        return proximo;
    }
    public NoDuplo getAnterior(){
        return anterior;
    }

    public void setInfo(int info){
        this.info = info;
    }
    public void setProximo(NoDuplo proximo){
        this.proximo = proximo;
    }
    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior;
    }
    @Override
    public String toString(){
        return "|" + info + "|";
    }
}
