package presentation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

public class presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
       IDao dao = (IDao) cDao.newInstance();

       String metierClassName = scanner.nextLine();
       Class cMetier = Class.forName(metierClassName);
      IMetier metier = (IMetier) cMetier.newInstance();
        Method method = cMetier.getMethod("setDao", IDao.class);
        method.invoke(metier,dao);

       System.out.println(dao.getData());
        System.out.println("Resultat" + metier.calcul());
    }
}
