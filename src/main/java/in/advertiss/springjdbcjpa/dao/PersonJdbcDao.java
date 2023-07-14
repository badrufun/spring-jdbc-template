package in.advertiss.springjdbcjpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){

        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));

        /*return jdbcTemplate.query("select * from person",
                new PersonRowMapper());*/
    }

    public Person findById(int id){
        //Depricated
        /*return jdbcTemplate.queryForObject("select * from person where id =?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));*/
        return jdbcTemplate.queryForObject("select * from person where id =?",
                new PersonRowMapper(),
                id);
    }

    public int deleteById(int id){
        //Can be used as
        /*return jdbcTemplate.update("select * from person where id =?",
                new Object[]{id});*/
        return jdbcTemplate.update("delete from person where id =?",
                id);
    }

    public int save(Person person){
        return jdbcTemplate.update("insert into " +
                        "person (id, name, location, birth_date) " +
                        "values (?,?,?,?)",
                        person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public int update(Person person){
        return jdbcTemplate.update("update person set " +
                        "name =?, location =?, birth_date =?" +
                        " where id =?",
                        person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }
}
