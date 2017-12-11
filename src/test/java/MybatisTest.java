

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.ExcelExport;
import com.tl.sm.pojo.Insurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	/*@Autowired
	private InsuranceMapper insuranceMapper;*/
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/*@Autowired
	private SalaryMapper salaryMapper;*/

	/*@Test
	public void testAdd() {
		List<ExcelExport> list = salaryMapper.exportAll("2017-12-08");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.size());
			System.out.println(list.get(i).getBankAccount());
		}
	}*/
	
	@Test
	public void testList() {
		List<Employee> cs = employeeMapper.listInner();
		for(Employee c : cs) {
			System.out.println("员工："+c.getSalId());
			List<Insurance> listIns = c.getSalInsuranceList();
			for(Insurance i :listIns) {
				System.out.println("保险："+i.getInsId());
			}
		}
	}
	
	/*@Test
	public void testList() {
		List<Employee> cs=employeeMapper.listInner();
		for (Employee c : cs) {
			System.out.println(c.getSalId());
			List<Insurance> listIns = c.getSalInsuranceList();
			for(Insurance i:listIns) {
				System.out.println(i.getInsName());
			}
		}
	}*/

	
}
