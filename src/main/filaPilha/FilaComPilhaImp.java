package filaPilha;

import list.FilaComPilha;

public class FilaComPilhaImp implements FilaComPilha {
    private PilhaImp p1;
    private PilhaImp p2;

    public FilaComPilhaImp(){
        this.p1 = new PilhaImp();
        this.p2 = new PilhaImp();
    }
    @Override
    public void	enqueue(int item){
        p1.push(item);
    }
    @Override
    public int	dequeue(){
        if (p2.isEmpty()){
            while (!p1.isEmpty()) {
                int num = p1.pop();
                p2.push(num);
            }
        }
        return p2.pop();
    }
    @Override
    public boolean isEmpty(){
        if(p1.isEmpty() && p2.isEmpty()){
            return true;
        }
        return false;
    }
    @Override
    public int size(){
        return (p1.getSize() + p2.getSize());
    }
}