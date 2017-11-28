

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.pojo.Insurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private InsuranceMapper insuranceMapper;
	
	/*@Autowired
	private DepartmentMapper departmentMapper;*/
	
	/*@Autowired
	private SalaryMapper salaryMapper;*/

	@Test
	public void testAdd() {
		Insurance insurance = insuranceMapper.selectByInsId("009898");
		System.out.println(insurance.getInsOld());
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
