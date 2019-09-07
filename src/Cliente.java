import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public List<Double> lances_globais;
    public List<Double> servicos_requisitados;
    public double somatorio_servicos;
    public List<Double> pesos;

    public Cliente(){
        lances_globais = new ArrayList<>();
        servicos_requisitados = new ArrayList<>();
        pesos = new ArrayList<>();
    }

    public void lances(int n){
        int aux = 0;
        while(aux < n){
            System.out.println("Por favor, entre com o valor do lance " + aux);
            Scanner sc = new Scanner(System.in);
            lances_globais.add(aux,sc.nextDouble());
            aux++;
        }
    }

    public void somatorio(){
        double a = 0;
        for(Double x : servicos_requisitados){
            a += Math.sqrt(x);
        }
        somatorio_servicos = a;
    }

    public void novoPeso(){
        int aux = 0;
        while(aux < lances_globais.size()){
            pesos.add(aux,(lances_globais.get(aux)/somatorio_servicos));
            aux++;
        }
    }
}
