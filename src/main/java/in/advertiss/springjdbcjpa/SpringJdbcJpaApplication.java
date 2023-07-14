package in.advertiss.springjdbcjpa;

import in.advertiss.springjdbcjpa.dao.Person;
import in.advertiss.springjdbcjpa.dao.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJdbcJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		//
		SpringApplication.run(SpringJdbcJpaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Person> list = personJdbcDao.findAll();
		logger.info("Persons : " + list);
		logger.info("Person : " + personJdbcDao.findById(10001));
		logger.info("Deleted id 10001 : " + personJdbcDao.deleteById(10001));
		logger.info("Inserted id 10009 : " + personJdbcDao.save(
				new Person(10009, "new name", "new location", new Date())
		));
		logger.info("Fetched id 10009 : " + personJdbcDao.findById(10009));

		logger.info("Update id 10003 : " + personJdbcDao.update(
				new Person(10003, "updated name", "updated location", new Date())
		));
		logger.info("updated id 10003 : " + personJdbcDao.findById(10003));
	}

}
