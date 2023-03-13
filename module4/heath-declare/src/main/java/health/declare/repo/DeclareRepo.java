package health.declare.repo;

import health.declare.model.Declare;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeclareRepo {
    private Map<String, Declare> declares = new HashMap<>();

    public void add(Declare declare){
        declares.put(declare.getId(), declare);
        System.out.println("Them moi thanh cong, kich thuoc collection la: "+declares.size());;
    }
}
