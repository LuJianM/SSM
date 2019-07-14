package com.ssm.test;

import com.ssm.model.Account;
import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountService;
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

        IAccountService accountService = ac.getBean("accountService",AccountService.class);


        List<Account> list = accountService.findAllAccount();


        for (Account account:list){
            //单引号不解析转义字符
            //System.out.println(account.getId()+"\t"+account.getName()+"\t"+account.getMoney());
            System.out.println(account.toString());
        }

//        Account account = null;
//
//        for (int i =0;i<list.size();i++){
//            account = list.get(i);
////            System.out.println(account.getId());
////            System.out.println(account.getName());
////            System.out.println(account.getMoney());
//
////            System.out.println(list.get(i).getId()+"\t"+"hahahha");
//
//            System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getMoney());
//        }

    }

    @Test
    public void testFindAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService",AccountService.class);

        Account account = accountService.findAccountById(1);
        System.out.println(account.getName());

    }

    @Test
    public void testSaveAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService",AccountService.class);

        Account account = new Account();
        account.setName("ddd");
        accountService.saveAccount(account);

        this.testFindAllAccount();

    }

    @Test
    public void testUpdateAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService",AccountService.class);

        Account account = new Account();

        account.setId(6);
        account.setName("fff");
        account.setMoney(120);

        accountService.UpdateAccountById(account);

        this.testFindAllAccount();

    }

    @Test
    public void testdeleteAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService",AccountService.class);

        Account account = new Account();

        account.setId(6);
        account.setName("fff");
        account.setMoney(120);

        accountService.deleteAccountByID(account);

        this.testFindAllAccount();
    }
}
