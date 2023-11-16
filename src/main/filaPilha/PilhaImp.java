package filaPilha;

import linked.ListaLigada;
import list.Pilha;

public class PilhaImp implements list.Pilha {

    private ListaLigada lista;
    private int size = 0;

    public PilhaImp(){
        this.lista = new ListaLigada();
    }
    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    @Override
    public void push(int item){
        lista.insereInicio(item);
        size += 1;
    }
    @Override
    public int pop(){
        int num = lista.buscaIndice(0);
        lista.removeInicio();
        size -= 1;
        return num;
    }
    public int getSize(){
        return this.size;
    }
}