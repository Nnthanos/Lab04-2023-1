package filaPilha;

import linked.ListaLigada;

public class FilaImp implements list.Fila{

    private ListaLigada lista;

    public FilaImp(){
        this.lista = new ListaLigada();
    }
    @Override
    public void	enqueue(int item){
        lista.insereFim(item);
    }
    @Override
    public int	dequeue(){
        int num = lista.buscaIndice(0);
        lista.removeInicio();
        return num;
    }
    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    @Override
    public int	size(){
        return lista.getIndice() + 1;
    }
}