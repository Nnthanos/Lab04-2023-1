import filaPilha.FilaComPilhaImp;
import filaPilha.FilaImp;
import filaPilha.PilhaImp;
import list.EstruturaElementar;


public class Main {
    public static void main(String[] args) {
    FilaComPilhaImp f1 = new FilaComPilhaImp();

    System.out.println(f1.isEmpty());
    System.out.println(f1.size());
    f1.enqueue(10);
    int num = f1.dequeue();
    f1.enqueue(20);
    System.out.println(f1.isEmpty());
    System.out.println(f1.size());
    
    System.out.println(f1.size());
    System.out.println(num);
    num = f1.dequeue();
    System.out.println(num);
    System.out.println(f1.isEmpty());

    }
}
