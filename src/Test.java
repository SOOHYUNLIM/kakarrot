import org.kakarrot.dao.BoardDAO;
import org.kakarrot.dao.BoardDAOImpl;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.Paging;

public class Test {

	public static void main(String[] args) {
		
		BoardDAO bd = new BoardDAOImpl();
		Paging p = new Paging();
		BoardVO bv = new BoardVO();

		bv.setTitle("test");
		bv.setWriter("³²±Ã¼º");
		bv.setContent("123");
		
		System.out.println(bd.insert(bv));
		
//		bd.selectList(p).forEach(System.out::println);
//		
//		System.out.println(bd.selectOne(1L));
//		
	}

}
