import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        List<Servico> provedor = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        System.out.println("Quantos servicos existem?");
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int aux = 0;
        while(aux < n){
            System.out.println("Qual a capacidade do servico " + aux);
            provedor.add(aux,new Servico(sc.nextDouble()));
            aux++;
        }
        aux = 0;
        System.out.println("Quantos clientes existem?");
        n = sc.nextInt();
        while (aux < n){
            clientes.add(aux,new Cliente(provedor));
            aux++;
        }
        ordenacao(clientes,0);

    }
    private static void ordenacao(List<Cliente> clientes,int index){
        if(index < clientes.size()){
            List<Double> ordem = new ArrayList<>();
            for(Cliente x: clientes){
                ordem.add(x.pesos.get(index));
            }
            quickSort(ordem,0,ordem.size() - 1);
            System.out.println("Ordem de Clintes: Servico " + index);
            for(Double y: ordem){
                System.out.println(y);
            }
            index++;
            ordenacao(clientes,index);
        }

    }

    private static void quickSort(List<Double> ordem, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(ordem, inicio, fim);
            quickSort(ordem, inicio, posicaoPivo - 1);
            quickSort(ordem, posicaoPivo + 1, fim);
        }
    }

    private static int separar(List<Double> ordem, int inicio, int fim) {
        double pivo = ordem.get(inicio);
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (ordem.get(i) <= pivo)
                i++;
            else if (pivo < ordem.get(f))
                f--;
            else {
                double troca = ordem.get(i);
                ordem.remove(i);
                ordem.add(i,ordem.get(f));
                ordem.remove(f);
                ordem.add(f,troca);
                i++;
                f--;
            }
        }
        ordem.remove(inicio);
        ordem.add(inicio,ordem.get(f));
        ordem.remove(f);
        ordem.add(f,pivo);
        return f;
    }
}
