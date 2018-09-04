package prj0614_01;
import java.util.*;

public class AddrManager {

	List<AddrBean> addrlist = new ArrayList<AddrBean>();
	
	public void add(AddrBean ab) {
		addrlist.add(ab);
	}
	
	public void del(AddrBean ab) {
		
		addrlist.remove(Integer.parseInt(ab.getIndex()));
	}
	public List<AddrBean> getAddrList() {
		return addrlist;
	}
}
