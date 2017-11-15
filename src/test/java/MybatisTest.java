

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tl.sm.mapper.AdminMapper;
import com.tl.sm.mapper.DepartmentMapper;
import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.pojo.Admin;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	/*@Autowired
	private EmployeeMapper employeeMapper;*/
	
	/*@Autowired
	private AdminMapper adminMapper;*/
	
	@Autowired
	private EmployeeMapper employeeMapper;

	/*@Test
	public void testAdd() {
		Admin admin = new Admin();
		admin.setAdm_count("adm_count");
		adminMapper.add(admin);
	}*/

	@Test
	public void testList() {
		List<Employee> cs=employeeMapper.listInner();
		for (Employee c : cs) {
			System.out.println(c.getSalId());
			List<Insurance> listIns = c.getSalInsuranceList();
			for(Insurance i:listIns) {
				System.out.println(i.getInsName());
			}
		}
	}

	/*@Test
	public void listAdmin() {
		List<Admin> cs=adminMapper.list();
		for (Admin c : cs) {
			System.out.println(c.getAdm_count());
		}
	}*/
	
}
