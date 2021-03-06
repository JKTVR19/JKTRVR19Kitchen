/*
 * 
 * Ветка SaveToBase2
 * Подключение базы данных и сохранение сущностей в базу
 * Шаги:
 * 1. добавить бибилотеки поставщика персистентности
 * (EclopseLink (JPA-2.1)) и драйвер базы данных (C:\Program Files\NetBeanse 8.2\ide\modules\ext\mysql-connector-java-5.1.23-bin.jar
 * 2. Добавить аннотации @Entity, @Id, @GeneratedValue и др. к полям сущностных классов.
 * 3. Создание базы с помощью phpmyadmin
 * 4. Создание persistence.xml (файла подключения к базе)
 *      В свойствах подключения прописываем после знака вопроса следующее:
 *      ?useUnicode=true&characterEncoding=utf8
 * 5. В persictence.xml добавляем классы сущностей.
 * 6. Создаем файл - менеджер сохранения в базе.
 * 
 * Ветка saveDataBaseOnly
 * 1. Подключение программы к базе данных без хранения массивов в программе.
 * 2. Создание фасадов (AbstractFacade и наследников) для уменьшения повторяемости кода.
 * 3. Создание фабрики FacadeFactory, чтобы поставлять объекты по требованию из стороннего объекта.
 * 4. Создание одиночки (Singleton) для оптимизации создания соединения с базой данных.
 * 5. Рефакторинг с целью оптимизировать код: удаление пакета tools.sever; удаления ненужных импортов.
 *  
 */
package jktvr19library;

import factory.ConnectSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author JKTVR19Library
 */
public class JKTVR19Kitchen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        App app = new App();
        try{
            app.run();
        } finally {
            ConnectSingleton connect = ConnectSingleton.getInstance();
            EntityManager em = connect.getEntityManager();
            EntityManagerFactory emf = connect.getEntityManagerFactory();
            if(em != null) {
                em.close();
            }
            if(emf != null){
                emf.close();
            }
            
        }
    }
    
}
