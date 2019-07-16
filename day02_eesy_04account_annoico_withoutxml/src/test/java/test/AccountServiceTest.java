package test;

import com.ssm.model.Account;
import com.ssm.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as = null;


    @Test
    public void testFindAllAccount() {


        List<Account> list = as.findAllAccount();

        for (Account account:list){
            System.out.println(account.toString());
        }

    }

    @Test
    public void testFindAccount() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = accountService.findAccountById(1);
        System.out.println(account.toString());

    }

    @Test
    public void testSaveAccount() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = new Account();
        account.setName("我是LJM");
        accountService.saveAccount(account);

        this.testFindAllAccount();

    }

    @Test
    public void testUpdateAccount() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = ac.getBean("accountServiceImpl",IAccountService.class);

        Account account = new Account();

        account.setId(7);
        account.setName("fff");
        account.setMoney(120);

        accountService.deleteAccount(account);

        this.testFindAllAccount();
    }
}
