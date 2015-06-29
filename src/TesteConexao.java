import com.plansoftonline.dao.SlaDao;


public class TesteConexao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
         SlaDao slaDao = new SlaDao();
         slaDao.listar(0, "");
         
	}

}
