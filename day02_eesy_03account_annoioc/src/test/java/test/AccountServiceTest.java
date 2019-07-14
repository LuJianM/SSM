package test;

import com.ssm.model.Account;
import com.ssm.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAllAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        List<Account> list = accountService.findAllAccount();

        for (Account account:list){
            System.out.println(account.toString());
        }

    }

    @Test
    public void testFindAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = accountService.findAccountById(1);
        System.out.println(account.toString());

    }

    @Test
    public void testSaveAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = new Account();
        account.setName("我是f");
        accountService.saveAccount(account);

        this.testFindAllAccount();

    }

    @Test
    public void testUpdateAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = new Account();

        account.setId(2);
        account.setName("我是B");
        account.setMoney(1500);

        accountService.updateAccount(account);

        this.testFindAllAccount();

    }

    @Test
    public void testdeleteAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = new Account();

        account.setId(7);
        account.setName("fff");
        account.setMoney(120);

        accountService.deleteAccount(account);

        this.testFindAllAccount();
    }
}
