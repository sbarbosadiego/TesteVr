
import com.testevr.dao.ClienteDao;
import com.testevr.dao.GenericDao;
import com.testevr.model.ClienteModel;
import com.testevr.model.ProdutoModel;
import java.time.LocalDateTime;
import java.util.List;

public class TesteVr {

    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setNomeCliente("Mais teste da Silva");
        clienteModel.setLimiteCompra(100.2);
        clienteModel.setDiaFechamentoFatura(agora.withMonth(2).withDayOfMonth(12));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(clienteModel.toString());
        
        GenericDao<ClienteModel> clienteDao = new GenericDao<>(ClienteModel.class);
        
        List<ClienteModel> listaClientes = clienteDao.retornarLista();
        for (ClienteModel cliente : listaClientes) {
            System.out.println(cliente);
        }
        
        
        
    }
}
