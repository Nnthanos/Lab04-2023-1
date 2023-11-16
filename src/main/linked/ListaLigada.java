package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar {

    private No cabeca;
    private int indice;

    public ListaLigada() {
        this.cabeca = null;
        this.indice = -1;
    }

    @Override
    public boolean buscaElemento(int valor) {
        No no = cabeca;
        while (no != null) {
            if (no.getValor() == valor) {
                return true;
            } else {
                no = no.getProximo();
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No no = cabeca;
        if (indice >= valor) {
            for (int i = 0; i < valor; i++) {
                no = no.getProximo();
            }
            return no.getValor();
        }
        return 0;
    }

    @Override
    public int minimo() {
        No no = cabeca;
        int valorMin = no.getValor();
        if (no == null) {
            return -1;
        }
        while (no != null) {
            if (valorMin > no.getValor()) {
                valorMin = no.getValor();
            }
            no = no.getProximo();
        }
        return valorMin;
    }

    @Override
    public int maximo() {
        No no = cabeca;
        int valorMax = no.getValor();
        if (no == null) {
            return -1;
        }
        while (no != null) {
            if (valorMax < no.getValor()) {
                valorMax = no.getValor();
            }
            no = no.getProximo();
        }
        return valorMax;
    }

    @Override
    public int predecessor(int valor) {
        if (indice >= valor && indice >= 1) {
            No no = cabeca;
            for (int i = 0; i < valor - 1; i++) {
                no = no.getProximo();
            }
            return no.getValor();
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        if (indice >= valor + 1 && indice > 0) {
            No no = cabeca;
            for (int i = 0; i < valor + 1; i++) {
                no = no.getProximo();
            }
            return no.getValor();
        } else {
            return -1;
        }
    }

    @Override
    public void insereElemento(int valor) {
        this.insereFim(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No no = cabeca;
        if (buscaIndice == 0) {
            this.insereInicio(valor);
        } else if (this.indice >= buscaIndice) {
            for (int i = 0; i <= buscaIndice - 1; i++) {
                no = no.getProximo();
            }
            No sucessor = no.getProximo();
            no.setProximo(new No(valor));
            no.getProximo().setProximo(sucessor);
            int aux = no.getProximo().getValor();
            indice += 1;
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (cabeca == null) {
            cabeca = new No(valor);
        } else {
            No no = new No(valor);
            no.setProximo(cabeca);
            cabeca = no;
        }
        indice += 1;
    }

    @Override
    public void insereFim(int valor) {
        if (cabeca == null) {
            cabeca = new No(valor);
        } else {
            No no = cabeca;
            for (int i = 0; i < indice; i++) {
                no = no.getProximo();
            }
            no.setProximo(new No(valor));
        }
        indice += 1;
    }

    @Override
    public void remove(int valor) {
        No no = cabeca;
        No auxiliar = no;
        while (no != null) {
            if (no.getValor() == valor) {
                if (no == cabeca) {
                    cabeca = cabeca.getProximo();
                } else {
                    auxiliar.setProximo(no.getProximo());
                }
            }
            auxiliar = no;
            no = no.getProximo();
        }
    }

    @Override
    public void removeIndice(int indice) {
        No no = cabeca;
        if (indice == 0) {
            this.removeInicio();
        } else if (this.indice >= indice) {
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            no.setProximo(no.getProximo().getProximo());
            this.indice -= 1;
        }

    }

    @Override
    public void removeInicio() {
        if (cabeca != null) {
            cabeca = cabeca.getProximo();
            indice -= 1;
        }
    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
        } else {
            No no = cabeca;
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            no.setProximo(null);
            indice -= 1;
        }
    }
    public boolean isEmpty(){
        if (cabeca != null){
            return false;
        }
        return true;

    }
    public int getIndice(){
        return this.indice;
    }

}