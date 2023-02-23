package listascirculares;

public class No<T> {

    private T conteudo;
    private No<T> noproximo;

    public No(T conteudo) {
        this.noproximo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNoproximo() {
        return noproximo;
    }

    public void setNoproximo(No<T> noproximo) {
        this.noproximo = noproximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}
