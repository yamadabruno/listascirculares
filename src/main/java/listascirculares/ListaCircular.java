package listascirculares;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<T>(conteudo);
        if(this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoproximo(cauda);
        }else{
            novoNo.setNoproximo(this.cauda);
            this.cabeca.setNoproximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No<T> noAuxiliar = this.cauda;
        if (index == 0){
            this.cauda = this.cauda.getNoproximo();
            this.cabeca.setNoproximo(this.cauda);
        }else if (index == 1){
            this.cauda.setNoproximo(this.cauda.getNoproximo().getNoproximo());
        }else{
            for (int i= 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoproximo();
            }
            noAuxiliar.setNoproximo(noAuxiliar.getNoproximo().getNoproximo());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        if (index == 0){
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoproximo();
        }
        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxliar = this.cauda;
        for (int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxliar.getConteudo() + "}]--->";
            noAuxliar = noAuxliar.getNoproximo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao inicio)" : "[]";

        return strRetorno;
    }
}
